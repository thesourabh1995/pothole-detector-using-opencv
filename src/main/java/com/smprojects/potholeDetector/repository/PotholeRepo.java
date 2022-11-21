package com.smprojects.potholeDetector.repository;

import com.smprojects.potholeDetector.entities.Pothole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PotholeRepo extends MongoRepository<Pothole, String> {

}
