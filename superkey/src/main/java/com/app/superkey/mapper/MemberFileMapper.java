package com.app.superkey.mapper;

import com.app.superkey.domain.dto.MemberFileDTO;
import com.app.superkey.domain.vo.MemberFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberFileMapper {
//    추가
    public void insert(MemberFileVO memberFileVO);
}
