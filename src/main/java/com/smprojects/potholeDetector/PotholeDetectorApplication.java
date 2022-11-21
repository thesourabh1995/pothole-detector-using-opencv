package com.smprojects.potholeDetector;

import com.smprojects.potholeDetector.repository.PotholeRepo;
import com.smprojects.potholeDetector.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class PotholeDetectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PotholeDetectorApplication.class, args);
	}

}
