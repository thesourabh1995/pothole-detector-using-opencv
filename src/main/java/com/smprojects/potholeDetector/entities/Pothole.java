package com.smprojects.potholeDetector.entities;

import com.smprojects.potholeDetector.dto.PotholeSize;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@Document(collection = "ps_pothole")
public class Pothole {
    @Id
    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private String userId;
    private PotholeSize size;
    private LocalDateTime timestamp;
    private String imagePath;
}
