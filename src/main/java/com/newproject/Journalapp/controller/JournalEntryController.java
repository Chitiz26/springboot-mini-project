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

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController
{
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;
    @GetMapping("{userName}")
    public ResponseEntity<?> GetAllJournalEntriesOfUser(@PathVariable String userName) //printing them all
    {
      User user= userService.findByUserName(userName);
      List<JournalEntry> all=user.getJournalEntries();
      if(all!=null && !all.isEmpty())
      {
          return new ResponseEntity<>(all,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> CreateEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName) //storing values
    {
        try {
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) //print by id
    {
        Optional<JournalEntry>journalEntry=journalEntryService.findById(myId);
        if (journalEntry.isPresent())
        {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myID) //delete by id
    {
        journalEntryService.deleteById(myID);
        return true;
    }
     //  @PutMapping //update by id
    // public JournalEntry updateJournalEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry)
    // {
    //      JournalEntry old=journalEntryService.findById(id).orElse(null);
    //    if(old!=null)
    //  {
    //       old.setTitle(newEntry.getTitle()!=null&&!newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
    //      old.setContent(newEntry.getContent()!=null&&!newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
    // }
    //journalEntryService.saveEntry(old, userName);
    //return old;
   // }
}
