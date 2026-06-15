package com.ewindsit.journal.Controller;

import com.ewindsit.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal") //adds mapping on the whole class
public class JournalEntryController {
private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//we use map to store entries
@GetMapping //general
    public List<JournalEntry> getAll() { // localhost:8080/journal GET
    return new ArrayList<>(journalEntries.values());
    // here we use list for entries
}
@PostMapping  //general
    public boolean createEntry(@RequestBody JournalEntry myEntry) { // localhost:8080/journal POST
//myEntry is a variable
    journalEntries.put(myEntry.getId(), myEntry); //adding the entries
    return true;

}
//if you want to send values through id
    // use two things path variable, request parameter
    //example localhost:8080/journal/id/2
    //id=path variable, 2=request parameter
@GetMapping("id/{myId}")
public JournalEntry getJournalEntryById(@PathVariable Long myId) { // localhost:8080/journal GET
    return journalEntries.get(myId);
    // in order to retrieve entries with path variable (id)

}
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return journalEntries.remove(myId);


    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry  ) {
        return journalEntries.put(id, myEntry);


    }

}




