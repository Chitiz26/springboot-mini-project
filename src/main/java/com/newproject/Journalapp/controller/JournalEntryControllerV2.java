package com.newproject.Journalapp.controller;
import com.newproject.Journalapp.entity.JournalEntry;
import com.newproject.Journalapp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
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
    public List<JournalEntry> getall() //printing them all
    {
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry CreateEntry(@RequestBody JournalEntry myEntry) //storing values
    {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) //print by id
    {
        return journalEntryService.findById(myId).orElse(null);
    }
    @DeleteMapping
    public boolean deleteJournalEntryById(@PathVariable ObjectId myID) //delete by id
    {
        journalEntryService.deleteById(myID);
        return true;
    }
    @PutMapping //update by id
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry)
    {
        JournalEntry old=journalEntryService.findById(id).orElse(null);
        if(old!=null)
        {
            old.setTitle(newEntry.getTitle()!=null&&!newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
            old.setContent(newEntry.getContent()!=null&&!newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}
