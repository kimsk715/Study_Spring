package com.app.threetier.mapper;

import com.app.threetier.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    추가
    public void insert(MemberVO memberVO);

//    조회(이메일)
    public Optional<MemberVO> selectByMemberEmail(String memberEmail);
}
