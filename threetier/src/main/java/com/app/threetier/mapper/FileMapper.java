package com.app.threetier.mapper;

import com.app.threetier.domain.dto.PostFileDTO;
import com.app.threetier.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
//    파일 추가
    public void insert(FileVO fileVO);

//    파일 삭제
    public void delete(Long id);
}
