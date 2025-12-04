package com.newproject.Journalapp.service;

import com.newproject.Journalapp.entity.JournalEntry;
import com.newproject.Journalapp.entity.User;
import com.newproject.Journalapp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService
{
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService; 
    public void saveEntry(JournalEntry journalEntry, String userName)
    {
        User user=userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved=journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
    }
    public List<JournalEntry> getAll()
    {
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId myId)
    {
        return journalEntryRepository.findById(myId);
    }
    public void deleteById(ObjectId id)
    {
        journalEntryRepository.deleteById(id);
    }
}
