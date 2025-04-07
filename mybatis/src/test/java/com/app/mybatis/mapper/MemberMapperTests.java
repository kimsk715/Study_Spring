package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testDelete(){
        Optional<MemberVO> foundMember = memberMapper.selectById(63L);
        foundMember.ifPresent((memberVO) -> {
            memberMapper.delete(memberVO.getId());
        });
    }

    @Test
    public void testUpdate(){
        Optional<MemberVO> foundMember = memberMapper.selectById(63L);
        foundMember.ifPresent((memberVO) -> {
            memberVO.setMemberAge(20);
            memberVO.setMemberName("TED");

            memberMapper.update(memberVO);
        });
    }

    @Test
    public void testSelectCountByMemberEmail(){
        int status = memberMapper.selectCountByMemberEmail("test@naver.com");
        log.info("status:{}", status);
    }

    @Test
    public void testSelectByMemberEmailAndMemberPassword(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hgd1234@gmail.com");
        memberVO.setMemberPassword("65465");
        MemberVO foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO).orElse(null);
        log.info(foundMember.toString());
    }

    @Test
    public void testInsert() {
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail("test@naver.com");
        memberVO.setMemberName("test");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberAge(20);
        memberVO.setMemberGender("선택 안함");

        memberMapper.insert(memberVO);
    }
}

















