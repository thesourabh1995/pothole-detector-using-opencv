package com.smprojects.potholeDetector.repository;

import com.smprojects.potholeDetector.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface UserRepo extends MongoRepository<User, String> {
//    public Object insert(User user);
}
