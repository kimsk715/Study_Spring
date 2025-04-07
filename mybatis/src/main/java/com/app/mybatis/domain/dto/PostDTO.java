package com.app.mybatis.domain.dto;

import com.app.mybatis.domain.vo.PostVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PostDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String postTitle;
    private String postContent;
    private String postReadCount;
    private Long memberId;
    private String memberName;
    private String createdDate;
    private String updatedDate;

    public PostVO toVO(){
        PostVO postVO = new PostVO();
        postVO.setId(id);
        postVO.setPostTitle(postTitle);
        postVO.setPostContent(postContent);
        postVO.setPostReadCount(postReadCount);
        postVO.setMemberId(memberId);
        postVO.setCreateDate(createdDate);
        postVO.setUpdatedDate(updatedDate);
        return postVO;
    }
}
