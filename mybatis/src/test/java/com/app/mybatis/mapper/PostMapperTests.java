package com.app.mybatis.mapper;

import com.app.mybatis.domain.dto.PostDTO;
import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.util.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testDelete(){
        postMapper.selectById(10354L).ifPresent((postDTO -> {
            postMapper.delete(postDTO.getId());
        }));
    }

    @Test
    public void testUpdate(){
        postMapper.selectById(10354L).ifPresent((postDTO -> {
            postDTO.setPostTitle("수정된 제목");
            postMapper.update(postDTO.toVO());
        }));
    }

    @Test
    public void testSelectById(){
        postMapper.selectById(10354L).ifPresent((postDTO -> {
            log.info(postDTO.toString());
        }));
    }

    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        pagination.setPage(8);
        pagination.create(postMapper.selectTotal());
        postMapper.selectAll(pagination).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void testInsert() {
        Random random = new Random();
        Long[] arId = {81L, 101L};
        PostVO post = new PostVO();
        MemberVO memberVO = new MemberVO();
        Optional<MemberVO> foundMember = null;


        memberVO.setMemberEmail("hgd1234@gmail.com");
        memberVO.setMemberPassword("1234");

        foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);

        foundMember.ifPresent((member) -> {
            IntStream.rangeClosed(2, 74).forEach((i) -> {
                post.setPostTitle("테스트 제목" + i);
                post.setPostContent("테스트 내용" + i);
                post.setMemberId(arId[random.nextInt(arId.length)]);

                postMapper.insert(post);
            });
        });
    }
}















