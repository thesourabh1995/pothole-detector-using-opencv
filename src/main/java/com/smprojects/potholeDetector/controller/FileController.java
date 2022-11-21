package com.smprojects.potholeDetector.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.lang.Nullable;
import com.smprojects.potholeDetector.dto.FileUploadRequestDto;
import com.smprojects.potholeDetector.entities.Pothole;
import com.smprojects.potholeDetector.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(path = "/fileUpload", consumes = {"multipart/form-data"})
    public ResponseEntity<Pothole> uploadFile(@Nullable @RequestParam(value = "file",required = false) MultipartFile file, @RequestParam(value = "fileUploadDto", required = false) String fileUploadDto) throws Exception {
        ObjectMapper obj = new ObjectMapper();
//        log.info("fileUploadDto ==> :  "+ fileUploadDto);
        FileUploadRequestDto fileUploadDtoParsed = obj.readValue(fileUploadDto, FileUploadRequestDto.class);
        return fileService.fileUpload(file, fileUploadDtoParsed);
    }
}
