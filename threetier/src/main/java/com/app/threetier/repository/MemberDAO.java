package com.app.threetier.repository;

import com.app.threetier.domain.dto.MemberDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    추가
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

//    조회(이메일)
    public Optional<MemberVO> findByMemberEmail(String memberEmail){
        return memberMapper.selectByMemberEmail(memberEmail);
    }
}
