package com.app.dependency.injection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CodingTests {
    @Autowired
    private Coding coding;

    @Test
    public void testCoding(){
        log.info("coding : {}", coding);
    }


    @Test
    public void testComputer(){
        log.info("computer : {}", coding.getComputer());
    }

    @Autowired
    private Food food;

    @Test
    public void testFood(){
        log.info("food : {}", food);
    }

    @Test
    public void testKnife() {
        log.info("knife : {}", food.getKnife());
    }
}
