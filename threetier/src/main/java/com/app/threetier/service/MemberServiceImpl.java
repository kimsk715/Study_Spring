package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

//    회원가입
    public void join(MemberDTO memberDTO){
        memberDAO.save(memberDTO.toVO());
    }

//    이메일로 회원 조회
    public Optional<MemberDTO> getMember(String memberEmail) {
        return Optional.ofNullable(
                toMemberDTO(
                        memberDAO.findByMemberEmail(memberEmail)
                                .orElseThrow(() -> {throw new RuntimeException();})));
    }
}















