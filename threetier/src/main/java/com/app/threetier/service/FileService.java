package com.app.threetier.service;

import com.app.threetier.domain.vo.FileVO;
import com.app.threetier.domain.vo.PostFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
//    파일 업로드
    public void upload(MultipartFile file){
        log.info("................" + file.getOriginalFilename());
        if(file.getOriginalFilename().equals("")){
            return;
        }
        String todayPath = getPath();
        String rootPath = "C:/upload/" + todayPath;
        UUID uuid = UUID.randomUUID();

        try {
            File directory = new File(rootPath);
            if(!directory.exists()){
                directory.mkdirs();
            }

            file.transferTo(new File(rootPath, uuid.toString() + "_" + file.getOriginalFilename()));

//            썸네일 가공
            if(file.getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid.toString() + "_" + file.getOriginalFilename()));
                Thumbnailator.createThumbnail(file.getInputStream(), out, 100, 100);
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
