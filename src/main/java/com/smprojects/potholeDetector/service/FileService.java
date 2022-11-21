package com.smprojects.potholeDetector.service;

import com.smprojects.potholeDetector.dto.FileUploadRequestDto;
import com.smprojects.potholeDetector.entities.Pothole;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public ResponseEntity<Pothole> fileUpload(MultipartFile file, FileUploadRequestDto fileUploadRequest) throws Exception;
}
