package com.elastic.springelastic.controller;

import com.elastic.springelastic.service.UserService;
import com.elastic.springelastic.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
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
        System.out.println(users);

        return userService.save(users);
    }

    @GetMapping("/findAll")
    public Iterable<Users> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public SearchHits<Users> findByName(@PathVariable String name) {

        return userService.findByName(name);
    }

    @GetMapping("/findSalary/{minSal}/{maxSal}")
    public SearchHits<Users> findSalary(@PathVariable String minSal, @PathVariable String maxSal) {

        return userService.findSalary(minSal, maxSal );
    }

    @GetMapping(path = "/search")
    public SearchHits<Users> searchUsers(@RequestParam String keywords) {
        System.out.println(keywords);
        return userService.search(keywords);
    }

    @GetMapping(value = "/delete")
    public boolean delete() {
        return userService.delete();
//        return template.deleteIndex(Users.class);
    }
}