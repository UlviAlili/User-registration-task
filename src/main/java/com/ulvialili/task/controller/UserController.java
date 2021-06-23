package com.ulvialili.task.controller;

import com.ulvialili.task.domain.User;
import com.ulvialili.task.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/account/signup")
    public User addUser(@RequestBody User user){
        user = userRepository.addUser(user);
        return user;
    }
}
