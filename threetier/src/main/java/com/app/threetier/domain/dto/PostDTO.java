package com.app.threetier.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private String memberName;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
    private Pagination pagination;
    private List<PostFileDTO> postFiles;
}
