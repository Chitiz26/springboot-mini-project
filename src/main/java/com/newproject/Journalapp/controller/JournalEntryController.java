package com.newproject.Journalapp.controller;

import com.newproject.Journalapp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController
{

  private Map<Long,JournalEntry>journalEntries=new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }


    @PostMapping
    public boolean CreateEntry(@RequestBody JournalEntry myEntry)
    {
       journalEntries.put(myEntry.getId(), myEntry);
       return true;
    }
    @GetMapping("id/{myID}")
        public JournalEntry getJournalEntryById(@PathVariable Long myID)
    {
        return journalEntries.get(myID);
    }
}
