package com.smprojects.potholeDetector.dto;

import lombok.Data;

@Data
public class FileUploadRequestDto {
    private String potholeName;
    private String fileName;
    private String userId;
    private PotholeSize potholeSize;
    private String latitude;
    private String longitude;
}
