package com.ewindsit.journal.Controller;

import com.ewindsit.journal.entity.JournalEntry;
import com.ewindsit.journal.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping //general
    public List<JournalEntry> getAll()
    {
        return journalEntryService.getAll();
    }

    @PostMapping  //general
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;//you can return myEntry
    }
//get journal entry by id, delete journal entry by id, update journal entry by id
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId)
    {
        return journalEntryService.findById(myId).orElse(null); //optional datatype is used to avoid null pointer exception, if not found return null
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId)
    {
      journalEntryService.deleteById(myId);
      return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry)
    {
//so we need to check if the entry exists or not, if it exists then update it, if not then create a new entry
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null)
        {

            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent());
            //so here i am not adding date because we want to keep the old date, if we add date then it will be updated to current date
        }

            journalEntryService.saveEntry(old);
            return old;
        }
    }






