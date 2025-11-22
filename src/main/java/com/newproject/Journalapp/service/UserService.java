package com.newproject.Journalapp.service;

import com.newproject.Journalapp.entity.JournalEntry;
import com.newproject.Journalapp.entity.User;
import com.newproject.Journalapp.repository.JournalEntryRepository;
import com.newproject.Journalapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public void saveEntry(User user)
    {
        userRepository.save(user);
    }
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId myId)
    {

        return userRepository.findById(myId);
    }
    public void deleteById(ObjectId id)
    {
        userRepository.deleteById(id);
    }
    public User findByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }
}
