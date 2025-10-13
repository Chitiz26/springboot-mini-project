package com.newproject.Journalapp.controller;

import com.newproject.Journalapp.entity.JournalEntry;
import com.newproject.Journalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2
{
    @Autowired
    public JournalEntryService journalEntryService;
    @GetMapping
    public List<JournalEntry> getAll() //printing them all
    {
        return null;
    }

    @PostMapping
    public boolean CreateEntry(@RequestBody JournalEntry myEntry) //storing values
    {
       journalEntryService.saveEntry(myEntry);
       return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myID) //print by id
    {
        return null;
    }
    @DeleteMapping
    public JournalEntry deleteJournalEntryById(@PathVariable Long myID) //delete by id
    {
        return null;
    }
    @PutMapping //update by id
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry)
    {
        return null;
    }
}
