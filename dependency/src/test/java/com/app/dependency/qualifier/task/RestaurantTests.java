package com.app.dependency.qualifier.task;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTests {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void testRestaurant() {
        log.info("restaurant : {}" , restaurant);
    }

    @Autowired @Qualifier ("vips")
    Restaurant vips;

    @Test
    public void testVips() {
        log.info("vips : {}" , vips);

    }
}
