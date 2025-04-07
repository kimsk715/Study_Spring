package com.app.threetier.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostFileVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long postId;
    private String fileType;
}
