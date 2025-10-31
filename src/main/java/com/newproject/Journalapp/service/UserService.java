package com.newproject.Journalapp.service;

import com.newproject.Journalapp.entity.JournalEntry;
import com.newproject.Journalapp.repository.JournalEntryRepository;
import com.newproject.Journalapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public void saveEntry(JournalEntry journalEntry)
    {

        userRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll()
    {

        return userRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId myId)
    {

        return userRepository.findById(myId);
    }
    public void deleteById(ObjectId id)
    {

        userRepository.deleteById(id);
    }
}
