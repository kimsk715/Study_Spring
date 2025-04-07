package com.app.threetier.mapper;

import com.app.threetier.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testSelectByMemberEmail(){
        log.info(memberMapper.selectByMemberEmail("apple.tedhan@gmail.com").orElse(null).toString());
    }
}
