package com.app.threetier.controller;

import com.app.threetier.domain.vo.FileVO;
import com.app.threetier.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/files/*")
public class FileController {
    private final FileService fileService;

    @PostMapping("upload")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile file) {
        fileService.upload(file);
    }

    @GetMapping("display")
    @ResponseBody
    public byte[] display(String path) throws IOException{
        byte[] file = null;
        try {
            file = FileCopyUtils.copyToByteArray(new File("C:/upload/" + path));
        }catch (NoSuchFileException e){
            throw new RuntimeException();
        }
        return file;
    }

    @GetMapping("download")
    public ResponseEntity<Resource> download(String path) throws IOException{
        Resource resource = new FileSystemResource("C:/upload/" + path);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + new String(("한동석짱_" + path.split("_")[1]).getBytes("UTF-8"), "ISO-8859-1"));
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }
}












