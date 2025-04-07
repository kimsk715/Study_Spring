package com.app.threetier.service;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.dto.PostFileDTO;
import com.app.threetier.domain.dto.PostListDTO;
import com.app.threetier.domain.vo.FileVO;
import com.app.threetier.domain.vo.PostFileVO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.repository.FileDAO;
import com.app.threetier.repository.PostDAO;
import com.app.threetier.repository.PostFileDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostService {
    private final PostDAO postDAO;
    private final FileDAO fileDAO;
    private final PostFileDAO postFileDAO;

    //    전체 목록
    public PostListDTO getList(Pagination pagination){
        PostListDTO postListDTO = new PostListDTO();

        pagination.create(postDAO.findTotal(pagination));
        postListDTO.setPagination(pagination);
        postListDTO.setPosts(postDAO.findAll(pagination));
        return postListDTO;
    }

//    전체 개수
    public int getTotal(Pagination pagination){
        return postDAO.findTotal(pagination);
    }

//    조회(아이디)
    public PostDTO read(Long id){
        postDAO.setReadCount(id);
        PostDTO foundPost = postDAO.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        });
        foundPost.setPostFiles(postFileDAO.selectByPostId(id));
        return foundPost;
    }

//    게시글 등록
    public void write(PostDTO postDTO, List<MultipartFile> files) {
        String todayPath = getPath();
        String rootPath = "C:/upload/" + todayPath;

        postDAO.save(postDTO);

        files.forEach((file) -> {
            if(file.getOriginalFilename().equals("")){
                return;
            }

            UUID uuid = UUID.randomUUID();

            FileVO fileVO = new FileVO();
            PostFileVO postFileVO = new PostFileVO();

            fileVO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
            fileVO.setFileSize(String.valueOf(file.getSize()));
            fileVO.setFilePath(todayPath);

            fileDAO.save(fileVO);

            postFileVO.setId(fileVO.getId());
            postFileVO.setPostId(postDTO.getId());

            postFileDAO.save(postFileVO);

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
        });

    }

//    게시글 수정(사용자가 선택한 파일만 삭제)
    public void update(PostDTO postDTO, Long[] arIdToDelete, List<MultipartFile> files){
        postDAO.setPost(postDTO);

//        삭제해야할 파일이 있다면,
        if(arIdToDelete != null && arIdToDelete.length > 0) {
//        삭제해야 할 파일의 정보
            List<PostFileDTO> foundPostFiles = postFileDAO.findAllById(arIdToDelete);

            //        서브키 삭제
            Arrays.asList(arIdToDelete).forEach((id) -> {
                postFileDAO.deleteById(id);
            });

            //        슈퍼키 삭제
            foundPostFiles.stream().map((foundPostFile) -> foundPostFile.getId()).forEach(fileDAO::delete);

            foundPostFiles.forEach((foundPostFile) -> {
                File file = new File("C:/upload", foundPostFile.getFilePath() + "/" + foundPostFile.getFileName());
                file.delete();
                if (foundPostFile.getFileType().equals("IMAGE")) {
                    file = new File("C:/upload", foundPostFile.getFilePath() + "/t_" + foundPostFile.getFileName());
                    file.delete();
                }
            });
        }

        String todayPath = getPath();
        String rootPath = "C:/upload/" + todayPath;

        files.forEach((file) -> {
            if(file.getOriginalFilename().equals("")){
                return;
            }

            UUID uuid = UUID.randomUUID();

            FileVO fileVO = new FileVO();
            PostFileVO postFileVO = new PostFileVO();

            fileVO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
            fileVO.setFileSize(String.valueOf(file.getSize()));
            fileVO.setFilePath(todayPath);

            fileDAO.save(fileVO);

            postFileVO.setId(fileVO.getId());
            postFileVO.setPostId(postDTO.getId());

            postFileDAO.save(postFileVO);

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
        });

    }

////    게시글 수정(파일 전체 삭제 후 전체 추가)
//    public void update(PostDTO postDTO, List<MultipartFile> files){
//        postDAO.setPost(postDTO);
//
//        List<PostFileDTO> foundPostFiles = postFileDAO.selectByPostId(postDTO.getId());
//
////        서브키 삭제
//        postFileDAO.delete(postDTO.getId());
//
////        슈퍼키 삭제
//        foundPostFiles.stream().map((foundPostFile) -> foundPostFile.getId()).forEach(fileDAO::delete);
//
//        foundPostFiles.forEach((foundPostFile) -> {
//            File file = new File("C:/upload", foundPostFile.getFilePath() + "/" + foundPostFile.getFileName());
//            file.delete();
//            if(foundPostFile.getFileType().equals("IMAGE")){
//                file = new File("C:/upload", foundPostFile.getFilePath() + "/t_" + foundPostFile.getFileName());
//                file.delete();
//            }
//        });
//
//        String todayPath = getPath();
//        String rootPath = "C:/upload/" + todayPath;
//
//        files.forEach((file) -> {
//            if(file.getOriginalFilename().equals("")){
//                return;
//            }
//
//            UUID uuid = UUID.randomUUID();
//
//            FileVO fileVO = new FileVO();
//            PostFileVO postFileVO = new PostFileVO();
//
//            fileVO.setFileName(uuid.toString() + "_" + file.getOriginalFilename());
//            fileVO.setFileSize(String.valueOf(file.getSize()));
//            fileVO.setFilePath(todayPath);
//
//            fileDAO.save(fileVO);
//
//            postFileVO.setId(fileVO.getId());
//            postFileVO.setPostId(postDTO.getId());
//
//            postFileDAO.save(postFileVO);
//
//            try {
//                File directory = new File(rootPath);
//                if(!directory.exists()){
//                    directory.mkdirs();
//                }
//
//                file.transferTo(new File(rootPath, uuid.toString() + "_" + file.getOriginalFilename()));
//
////            썸네일 가공
//                if(file.getContentType().startsWith("image")){
//                    FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuid.toString() + "_" + file.getOriginalFilename()));
//                    Thumbnailator.createThumbnail(file.getInputStream(), out, 100, 100);
//                    out.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//    }

//    게시글 삭제
    public void delete(Long id){
        List<PostFileDTO> foundPostFiles = postFileDAO.selectByPostId(id);

//        서브키 삭제
        postFileDAO.delete(id);

//        슈퍼키 삭제
        foundPostFiles.stream().map((foundPostFile) -> foundPostFile.getId()).forEach(fileDAO::delete);

//        게시글 삭제
        postDAO.delete(id);

        foundPostFiles.forEach((foundPostFile) -> {
            File file = new File("C:/upload", foundPostFile.getFilePath() + "/" + foundPostFile.getFileName());
            file.delete();
            if(foundPostFile.getFileType().equals("IMAGE")){
                file = new File("C:/upload", foundPostFile.getFilePath() + "/t_" + foundPostFile.getFileName());
                file.delete();
            }
        });
    }

    private String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

}










