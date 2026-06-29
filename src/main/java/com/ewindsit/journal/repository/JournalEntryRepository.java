package com.ewindsit.journal.repository;

import com.ewindsit.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>//journalentry, id type

//so here we extended mongo repo class,
// we added JournalEntry as a parameter and id type is string
{

}
