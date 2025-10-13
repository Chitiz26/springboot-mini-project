package com.newproject.Journalapp.repository;

import com.newproject.Journalapp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

//{Best Practice}
// controller --> service --> Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry,String>
{

}
