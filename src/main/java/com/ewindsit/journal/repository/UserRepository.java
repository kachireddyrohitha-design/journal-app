package com.ewindsit.journal.repository;

import com.ewindsit.journal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId>//user, id type
{
    User findByUsername(String username);


}
