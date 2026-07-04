package com.ewindsit.journal.entity;

import lombok.Data;
import lombok.NonNull;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//login functionality will be given to the user entity class
//user's collection will be created in the mongo db database
    @Document(collection = "users")

    @Data
    public class User {
        @Id //primary key
        private ObjectId id;
        @Indexed(unique = true) //username should be unique
        @NonNull   //CONSTRAINT: username cannot be null
        private String username;
        @NonNull   //CONSTRAINT: password cannot be null
        private String password;
        private LocalDateTime createdAt;
        @DBRef //this annotation is used to create a reference to another document in the database
        private List<JournalEntry> journalEntries = new ArrayList<>();
        //array list to store the journal entries of the user
        //it acts like foreign key in relational database

}
