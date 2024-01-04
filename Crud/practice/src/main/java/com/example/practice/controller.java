package com.example.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/PRAC")
public class controller {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(path="/add")
    public User addUser(@RequestParam String name,@RequestParam String email){
        User SpringUser = new User();
        SpringUser.setName(name);
        SpringUser.setEmail(email);
        userRepo.save(SpringUser);
        return SpringUser;
    }

    @RequestMapping(path="/all")
    public Iterable<User> getUsers(){
        return userRepo.findAll();
    }

}
