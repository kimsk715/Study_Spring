package com.app.controller.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentVO {
    @EqualsAndHashCode.Include
    private String name;
    private int kor;
    private int eng;
    private int math;
}
