package com.app.threetier.controller;

import com.app.threetier.domain.dto.MemberDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.service.KakaoService;
import com.app.threetier.service.MemberServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class KakaoController {
    private final HttpSession session;
    private final KakaoService kakaoService;
    private final MemberServiceImpl memberService;


    @GetMapping("/kakao/login")
    public RedirectView login(String code){
        String token = kakaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> foundInfo = kakaoService.getKakaoInfo(token);

        MemberDTO memberDTO = foundInfo.orElseThrow(() -> {
            throw new RuntimeException();
        });

        Optional<MemberDTO> foundMember = memberService.getMember(memberDTO.getMemberEmail());
        if(!foundMember.isPresent()){
            memberService.join(memberDTO);
        }

        session.setAttribute("member", foundMember.orElseThrow(() -> {throw new RuntimeException();}));
        return new RedirectView("/post/list");
    }
}
















