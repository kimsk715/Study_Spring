package com.app.threetier.service;

import com.app.threetier.domain.dto.MemberDTO;
import com.app.threetier.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

public interface MemberService {
    public void join(MemberDTO memberDTO);
    public Optional<MemberDTO> getMember(String memberEmail);

    public default MemberDTO toMemberDTO(MemberVO memberVO) {
        return MemberDTO
                .builder()
                .id(memberVO.getId())
                .memberName(memberVO.getMemberName())
                .memberEmail(memberVO.getMemberEmail())
                .memberPassword(memberVO.getMemberPassword())
                .memberAge(memberVO.getMemberAge())
                .memberGender(memberVO.getMemberGender())
                .build();
    }
}
