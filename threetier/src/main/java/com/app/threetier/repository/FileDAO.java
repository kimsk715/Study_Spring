package com.app.threetier.repository;

import com.app.threetier.domain.vo.FileVO;
import com.app.threetier.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

//    추가하기
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

//    파일 삭제
    public void delete(Long id){
        fileMapper.delete(id);
    }
}
