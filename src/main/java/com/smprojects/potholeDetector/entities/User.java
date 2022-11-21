package com.smprojects.potholeDetector.entities;

import com.smprojects.potholeDetector.dto.UserType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ps_users")
public class User {
    @Id
    private String id;
    private String fname;
    private String lname;
    private String mobNo;
    private String email;
    private UserType userType;
}
