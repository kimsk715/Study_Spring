package com.app.dependency.qualifier.task;

import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Getter
public class Outback implements Restaurant {
    int price;

    @Override
    public boolean saladBar() {
        return false;
    }


    public void Outback() {
        this.price = Restaurant.price + 1000;
    }
}
