package com.app.superkey.mapper;

import com.app.superkey.domain.dto.MemberFileDTO;
import com.app.superkey.domain.vo.FileVO;
import com.app.superkey.domain.vo.MemberFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberFileMapperTests {
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private MemberFileMapper memberFileMapper;

    @Test
    public void testInsert(){
        MemberFileDTO memberFileDTO = new MemberFileDTO();
        memberFileDTO.setFilePath("/upload/member");
        memberFileDTO.setFileName("애버랜드.png");
        memberFileDTO.setFileSize("2048");
        memberFileDTO.setMemberId(81L);

        FileVO fileVO = new FileVO();
        fileVO.setFilePath(memberFileDTO.getFilePath());
        fileVO.setFileName(memberFileDTO.getFileName());
        fileVO.setFileSize(memberFileDTO.getFileSize());

        fileMapper.insert(fileVO);

        MemberFileVO memberFileVO = new MemberFileVO();
        memberFileVO.setId(fileVO.getId());
        memberFileVO.setMemberId(memberFileDTO.getMemberId());

        memberFileMapper.insert(memberFileVO);
    }
}















