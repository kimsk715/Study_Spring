package com.app.superkey.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FileVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String fileName;
    private String fileSize;
    private String filePath;
    private String createdDate;
    private String updatedDate;
}
