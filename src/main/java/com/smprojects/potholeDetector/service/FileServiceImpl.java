package com.smprojects.potholeDetector.service;

import com.smprojects.potholeDetector.dto.FileUploadRequestDto;
import com.smprojects.potholeDetector.dto.UserType;
import com.smprojects.potholeDetector.entities.Pothole;
import com.smprojects.potholeDetector.entities.User;
import com.smprojects.potholeDetector.repository.PotholeRepo;
import com.smprojects.potholeDetector.repository.UserRepo;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

//    @Autowired
//    private UserRepo userRepo;

    @Autowired
    private PotholeRepo potholeRepo;

    public ResponseEntity<Pothole> fileUpload(MultipartFile file, FileUploadRequestDto fileUploadDto) throws Exception {
        try{
            //file upload to cloud storage
            String filePath = uploadFileToLocal(file);

            //update metadata on mongodb
            Pothole pothole = new Pothole();
            pothole.setLatitude(fileUploadDto.getLatitude());
            pothole.setLongitude(fileUploadDto.getLongitude());
            pothole.setImagePath(filePath);
            pothole.setName(fileUploadDto.getPotholeName());
            pothole.setSize(fileUploadDto.getPotholeSize());
            pothole.setUserId(fileUploadDto.getUserId());
            pothole.setTimestamp(LocalDateTime.now());
            potholeRepo.save(pothole);
            return new ResponseEntity<>(pothole, HttpStatus.CREATED);

        }catch(Exception e){
            System.out.println("Error while saving pothole :: "+ e);
            throw new Exception("Error while saving pothole");
        }

    }

    private String uploadFileToLocal(MultipartFile file) throws Exception {
        try{
            String fileId = UUID.randomUUID().toString();
            File path = new File("C:\\Users\\002V6O744\\workplace\\java-practice\\fileuploads\\"+file.getOriginalFilename());
            path.createNewFile();
            FileOutputStream output = new FileOutputStream(path);
            output.write(file.getBytes());
            return path.getPath();
//            return ResponseHandler.generateResponse("File is uploaded successfully!", HttpStatus.OK, path);
        }catch(Exception e){
            System.out.println("Error while uploading file :: "+ e);
            throw new Exception("Error while uploading file");
        }
    }


}
