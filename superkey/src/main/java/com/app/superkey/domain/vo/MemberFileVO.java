package com.app.superkey.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberFileVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
}
