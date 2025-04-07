package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    추가하기
    public void insert(MemberVO memberVO);

//    조회(아이디/비밀번호)
    public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO);

//    이메일 중복 검사
    public int selectCountByMemberEmail(String memberEmail);

//    조회(회원 번호)
    public Optional<MemberVO> selectById(Long id);

//    수정
    public void update(MemberVO memberVO);

//    삭제
    public void delete(Long id);
}
