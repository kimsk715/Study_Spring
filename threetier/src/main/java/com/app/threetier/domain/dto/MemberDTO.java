package com.app.threetier.domain.dto;

import com.app.threetier.domain.vo.MemberVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Integer memberAge;
    private String memberGender;
    private String createdDate;
    private String updatedDate;

    @Builder
    public MemberDTO(Long id, String memberEmail, String memberPassword, String memberName, Integer memberAge, String memberGender, String createdDate, String updatedDate) {
        this.id = id;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.memberGender = memberGender;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public MemberVO toVO(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(id);
        memberVO.setMemberEmail(memberEmail);
        memberVO.setMemberPassword(memberPassword);
        memberVO.setMemberName(memberName);
        memberVO.setMemberAge(memberAge);
        memberVO.setMemberGender(memberGender);
        memberVO.setCreatedDate(createdDate);
        memberVO.setUpdatedDate(updatedDate);

        return memberVO;
    }


}

















