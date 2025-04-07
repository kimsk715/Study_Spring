package com.app.controller.ex;

import com.app.controller.domain.MemberVO;
import com.app.controller.domain.StudentVO;
import com.app.controller.exception.TestException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public void ex01(){
        log.info("ex01");
    }

//    ex02를 선언하고, 본인의 이름을 콘솔창에 출력한다.
//    알맞은 경로에 ex02.html을 생성하고 h1태그로 EX02를 출력한다.
    @GetMapping("ex02")
    public void ex02(){
        log.info("한동석");
    }

    @GetMapping("ex03")
    public void ex03(@ModelAttribute("age") int age){
        log.info("나이: {}", age);
    }
    
//    이름을 전달받은 뒤 HTML에서 H1태그로 출력하기
    @GetMapping("ex04")
    public void ex04(String name, Model model){
        model.addAttribute("name", name);
    }

    @GetMapping("ex05")
    public void ex05(@ModelAttribute MemberVO memberVO){
        log.info(memberVO.toString());
    }

//    학생 객체 생성(이름, 국어, 영어, 수학)
//    Convention에 맞게 제작한 뒤
//    ex06 제작
//    평균 출력
    @GetMapping("ex06")
    public void ex06(@ModelAttribute StudentVO studentVO, Model model){
        int total = studentVO.getEng() + studentVO.getKor() + studentVO.getMath();
        double average = Math.round(total / 3.0);
        model.addAttribute("average", average);
        log.info("평균: {}점", average);
    }

    @GetMapping("test")
    public String test(Integer status){
        if(status == null){
            throw new TestException("오류 발생!!");
        }
        return "index";
    }
}
















