package com.rest.webservices.restfulwebservices.Controller;


import com.rest.webservices.restfulwebservices.Models.User;
import com.rest.webservices.restfulwebservices.Services.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {

    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public List<User> retirieveAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userDao.findOne(id);
    }

    @PostMapping("/add/user")
    public ResponseEntity addUser(@RequestBody User user) {
        User savedUser = userDao.saveUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
