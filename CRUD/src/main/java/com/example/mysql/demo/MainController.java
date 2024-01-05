package com.example.mysql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(path = "/CRUD")
public class MainController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @PostMapping(path = "/add")
    public @ResponseBody User addNewuser(@RequestParam String name, @RequestParam String email){
        User springUser = new User();
        springUser.setName(name);
        springUser.setEmail(email);
        userRepository.save(springUser);
        return springUser;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping(path="/remove/{id}")
    public @ResponseBody Iterable<User> deleteUser(@PathVariable("id") Integer id ){
        userRepository.deleteById(id);
        return userRepository.findAll();

    }

    @PutMapping(path="update/{id}")
    public @ResponseBody User updateUser(@PathVariable("id") Integer id, @RequestParam String name, @RequestParam String email, User UpdatedUser){

        if(userRepository.existsById(id)){
            UpdatedUser.setName(name);
            UpdatedUser.setEmail(email);
            UpdatedUser.setId(id);
            userRepository.save(UpdatedUser);
        }
        else{
           return null;
        }
        return UpdatedUser;


    }
}


