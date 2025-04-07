package com.app.threetier.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JavaMailSender javaMailSender;

//    메일 전송
    public void sendMail(HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        String code = createCode();

        Cookie cookie = new Cookie("token", code);
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/"); //모든 경로에서 접근 가능하도록 설정
        response.addCookie(cookie);

        String receiver = "tedhan1204@gmail.com";
        String sender = "dev.tedhan@gmail.com";
        String title = "인증";

        StringBuilder body = new StringBuilder();
        body.append("<html><body>");
        body.append("<a href=\"http://localhost:10000/auth/confirm?code=" + code + "\">인증 하러 가기</a>");
        body.append("</body></html>");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(body.toString(), true);

        javaMailSender.send(mimeMessage);
    }

//    코드 생성
    private String createCode(){
        String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        Random random = new Random();

        for(int i=0; i<10; i++) {
            code += codes.charAt(random.nextInt(codes.length()));
        }
        return code;
    }
}
