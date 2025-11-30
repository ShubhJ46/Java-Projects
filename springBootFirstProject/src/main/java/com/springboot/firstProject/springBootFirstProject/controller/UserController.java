package com.springboot.firstProject.springBootFirstProject.controller;

import com.springboot.firstProject.springBootFirstProject.model.User;
import com.springboot.firstProject.springBootFirstProject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
       return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User u) {
        return userService.addUser(u);
    }

}
