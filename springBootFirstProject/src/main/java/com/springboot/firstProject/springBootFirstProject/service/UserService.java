package com.springboot.firstProject.springBootFirstProject.service;

import com.springboot.firstProject.springBootFirstProject.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(1, "Shubham"));
        users.add(new User(2, "Aman"));
    }

    public List<User> getUsers() { return users; }

    public User addUser(User u) {
        users.add(u);
        return u;
    }


}
