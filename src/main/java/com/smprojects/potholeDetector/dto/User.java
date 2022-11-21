package com.smprojects.potholeDetector.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class User {
    private String id;
    private String fName;
    private String lName;
    private String mobNo;
    private String email;
    private UserType userType;
}
