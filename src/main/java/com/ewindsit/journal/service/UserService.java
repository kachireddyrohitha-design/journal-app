package com.ewindsit.journal.service;

import com.ewindsit.journal.entity.User;
import com.ewindsit.journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    //business logic
    //here we are trying to connect database
    @Autowired //dependency injection
    private UserRepository userRepository; //userRepository calls using autowired and field injection
    //interface's implementation

    public void saveUser(User user)
    {//for post method
        userRepository.save(user);// save is in mongo class crud repository
    }

    public List<User> getAll()
    { //for get method
        return userRepository.findAll(); //findAll is in mongo class crud repository
    }

    public Optional<User> findById(ObjectId id)
    {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id)
    {
        userRepository.deleteById(id);
    }

}
//controller --> service --> repository
