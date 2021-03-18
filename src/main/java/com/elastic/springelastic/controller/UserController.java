package com.elastic.springelastic.controller;

import com.elastic.springelastic.service.UserService;
import com.elastic.springelastic.model.Users;
import com.elastic.springelastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public Users saveUser(@RequestBody Users users) {
        return userService.save(users);
    }

    @GetMapping("/findAll")
    public Iterable<Users> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public List<Users> findByName(@PathVariable String name) {

        return userService.findByName(name);
    }
}