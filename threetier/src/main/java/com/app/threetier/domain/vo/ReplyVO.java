package com.app.threetier.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReplyVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String replyContent;
    private Long memberId;
    private Long postId;
    private String createdDate;
    private String updatedDate;
}
