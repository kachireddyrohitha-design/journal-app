package com.ewindsit.journal.entity;

import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
//this annotation says spring that these are the details of a mongo db documents

//journal entry = document(collection in mongo db)
public class JournalEntry {
    @Id //primary key
    private ObjectId id;
    private String title;
    private String content;

    private LocalDateTime date;


    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getContent()
    {
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
