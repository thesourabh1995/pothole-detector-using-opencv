package com.smprojects.potholeDetector.service;


import com.smprojects.potholeDetector.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public ResponseEntity<User> createUser(User user);
    public ResponseEntity<User> getUserById(String id);
    public ResponseEntity<List<User>> getUser();

}
