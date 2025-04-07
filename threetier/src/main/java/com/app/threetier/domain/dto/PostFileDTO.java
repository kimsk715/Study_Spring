package com.app.threetier.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostFileDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String fileName;
    private String fileSize;
    private String filePath;
    private Long postId;
    private String fileType;
    private String createdDate;
    private String updatedDate;
}
