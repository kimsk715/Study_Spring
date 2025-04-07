package com.app.threetier.domain.dto;

import com.app.threetier.domain.vo.ReplyVO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@Slf4j
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReplyDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String replyContent;
    private Long memberId;
    private Long postId;
    private String memberName;
    private String createdDate;
    private String updatedDate;

    public ReplyVO toVO(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setId(id);
        replyVO.setReplyContent(replyContent);
        replyVO.setMemberId(memberId);
        replyVO.setPostId(postId);
        replyVO.setCreatedDate(createdDate);
        replyVO.setUpdatedDate(updatedDate);
        return replyVO;
    }
}









