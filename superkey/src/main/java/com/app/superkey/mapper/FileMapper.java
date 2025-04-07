package com.app.superkey.mapper;

import com.app.superkey.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
//    추가
    public void insert(FileVO fileVO);
}
