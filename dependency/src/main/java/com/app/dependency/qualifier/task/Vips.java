package com.app.dependency.qualifier.task;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier ("vips")
@Getter
public class Vips implements Restaurant {
    @Override
    public boolean saladBar() {
        return false;
    }

        public Vips(){
            this.price = Restaurant.price + 2000;
        }
}
