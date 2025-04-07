package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ComputerTests {
    @Autowired @Qualifier("desktop")
    Computer computer;
//    Junit 이 관여하므로 순환 참조 등을 고려할 필요가 없음.

    @Autowired
    Computer laptop;


    @Test
    public void testComputer() {
        log.info("computer: {}" , computer);
    }

    @Test
    public void testLaptop() {
        log.info("laptop: {}" , laptop);
    }

}


