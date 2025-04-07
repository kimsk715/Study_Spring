package com.app.controller.ex;

import com.app.controller.domain.MemberVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rests")
public class RestExampleController {
    @GetMapping("ex01")
    public String ex01(){
        return "EX01";
    }

    @GetMapping("ex02")
    public MemberVO ex02(){
        MemberVO member = new MemberVO();
        member.setName("한동석");
        member.setAge(20);
        return member;
    }
}
