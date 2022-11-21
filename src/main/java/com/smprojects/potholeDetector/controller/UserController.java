package com.smprojects.potholeDetector.controller;

import com.smprojects.potholeDetector.entities.User;
import com.smprojects.potholeDetector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getById")
    public ResponseEntity<User> getUserById(@RequestParam String id){
        return userService.getUserById(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUser(){
        return userService.getUser();
    }
}
