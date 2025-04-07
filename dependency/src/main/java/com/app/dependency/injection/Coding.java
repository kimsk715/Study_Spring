package com.app.dependency.injection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
// final 키워드가 붙어있거나 @NonNull 키워드가 붙어있는 필드를 대상으로
// 초기화 생성자를 만들어준다.

public class Coding {
    /*
    필드 주입(생성 후 주입)
    사용 방법이 매우 편함.
    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있음.
    생성 시점에서는 순환 참조 발생 여부를 알 수 없음.
    */

    /*
    @Autowired
    private Computer computer;
    */

    /*
    Setter 주입(생성 후 주입)
    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있음.
    OCP(Open-Closed Principle, 개방-폐쇄 법칙)를 위반하기 떄문에 변경 가능성을 배제하고 불변성을 보장하는 것이 좋음.
    화면으로부터 값을 받을 때에는 Spring 이 Setter 주입을 통해 객체를 넣기 때문에 필수적임.
    */

     /*
     private Computer computer;
     @Autowired
     public void setComputer(Computer computer) {
         this.computer = computer;
     }
     */


    /*
    생성자 주입(생성과 동시에 주입)
    */

    private final Computer computer;
    /*
    @Autowired
    public Coding(Computer computer) {
        this.computer = computer;
    }
    */
}