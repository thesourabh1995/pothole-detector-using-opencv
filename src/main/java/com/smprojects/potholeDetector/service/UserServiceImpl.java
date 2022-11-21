package com.smprojects.potholeDetector.service;

import com.smprojects.potholeDetector.entities.User;
import com.smprojects.potholeDetector.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<User> createUser(User user){
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUserById(String id){
        User user = userRepo.findById(id).orElse(null);
        if(ObjectUtils.isEmpty(user)){
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<User>> getUser(){
        List<User> users = userRepo.findAll();
        if(ObjectUtils.isEmpty(users)){
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
        }
    }
}
