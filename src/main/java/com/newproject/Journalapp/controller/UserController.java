package com.newproject.Journalapp.controller;
import com.newproject.Journalapp.entity.JournalEntry;
import com.newproject.Journalapp.entity.User;
import com.newproject.Journalapp.service.JournalEntryService;
import com.newproject.Journalapp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers()
    {
       return userService.getAll();
    }
    @PostMapping
    public  void createUser()
    {
        return userService.saveEntry(User);
    }

}
