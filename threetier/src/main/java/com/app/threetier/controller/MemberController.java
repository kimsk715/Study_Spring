package com.app.threetier.controller;

import com.app.threetier.domain.dto.MemberDTO;
import com.app.threetier.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;

    @GetMapping("join")
    public void goToJoinForm(MemberDTO memberDTO){}

    @PostMapping("join")
    public void join(MemberDTO memberDTO){
        memberService.join(memberDTO);
    }

    @GetMapping("login")
    public void goToJoinForm(){}
}
