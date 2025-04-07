package com.app.threetier.mapper;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.dto.ReplyDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testInsert(){
        Optional<MemberVO> foundMember = memberMapper.selectByMemberEmail("apple.tedhan@gmail.com");
        foundMember.ifPresent((member) -> {
            Optional<PostDTO> foundPost = postMapper.selectById(10441L);
            foundPost.ifPresent((post) -> {
                ReplyVO replyVO = new ReplyVO();
                replyVO.setReplyContent("테스트 댓글1");
                replyVO.setPostId(post.getId());
                replyVO.setMemberId(member.getId());
                replyMapper.insert(replyVO);
            });
        });
    }

    @Test
    public void testSelectAllByPostId(){
        Optional<PostDTO> foundPost = postMapper.selectById(10441L);
        foundPost.ifPresent((post) -> {
            Pagination pagination = new Pagination();
            pagination.setPage(1);
            pagination.create(replyMapper.selectTotalByPostId(post.getId()));
            replyMapper
                    .selectAllByPostId(pagination, post.getId())
                    .stream().map(ReplyDTO::toString)
                    .forEach(log::info);
        });
    }
}















