package com.ximen.springbootupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @RequestMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return "error";
        }
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        Path path = Paths.get("e://temp//" + file.getOriginalFilename());
//        Files.copy(file.getInputStream(), path);
        Files.write(path, file.getBytes());
        return "success";
    }
    @RequestMapping("index")
    public String index(){
        return "upload";
    }
}
