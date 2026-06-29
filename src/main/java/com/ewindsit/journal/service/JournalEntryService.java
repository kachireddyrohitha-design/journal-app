package com.ewindsit.journal.service;
import com.ewindsit.journal.entity.JournalEntry;
import com.ewindsit.journal.repository.JournalEntryRepository;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    //business logic
    //here we are trying to connect database
    @Autowired //dependency injection
    private JournalEntryRepository journalEntryRepository;
    //interface's implementation

    public void saveEntry(JournalEntry journalEntry)
    {//for post method
        journalEntryRepository.save(journalEntry);// save is in mongo class crud repository
    }
    public List<JournalEntry> getAll()
    { //for get method
        return journalEntryRepository.findAll(); //findAll is in mongo class crud repository

    }
    public Optional<JournalEntry> findById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id)
    {
        journalEntryRepository.deleteById(id);
    }


}
//controller --> service --> repository
