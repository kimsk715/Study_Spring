package com.app.threetier.controller;

import com.app.threetier.service.AuthService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
@RequestMapping("/auth/*")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @GetMapping("link")
    public void goToLinkPage(){;}

//    메일 전송
    @PostMapping("link")
    public void link(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException {
        authService.sendMail(request, response);
    }

//    링크 확인
    @GetMapping("confirm")
    public RedirectView confirm(@CookieValue(name="token", required = false) String token, String code, HttpServletResponse response) throws IOException, MessagingException {
        if(token == null) {
            return new RedirectView("/auth/fail");
        }
        if(token.equals(code)){
            Cookie cookie = new Cookie("token", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new RedirectView("/auth/success");
        }
        return new RedirectView("/auth/fail");

    }

    @GetMapping("success")
    public void goToSuccessPage(){}

    @GetMapping("fail")
    public void goToFailPage(){}
}











