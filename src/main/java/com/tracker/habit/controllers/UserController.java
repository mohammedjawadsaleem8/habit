package com.tracker.habit.controllers;

import com.tracker.habit.entity.Users;
import com.tracker.habit.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> allUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public boolean insertUser(@RequestBody Users users){
        log.info("Save is getting called");
        Users save = userRepository.save(users);
        log.info("Save call success");
        return true;
    }
}
