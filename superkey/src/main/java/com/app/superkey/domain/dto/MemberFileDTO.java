package com.app.superkey.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class MemberFileDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String fileName;
    private String fileSize;
    private String filePath;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
}
