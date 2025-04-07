package com.app.threetier.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final JavaMailSender javaMailSender;

    @GetMapping("/mails")
    public void sendMail() throws MessagingException {
        String receiver = "rksel0712@gmail.com";
        String sender = "dev.tedhan@gmail.com";
        String title = "테스트!";

        StringBuilder body = new StringBuilder();
        body.append("<html><body>");
        body.append("<h1>간디 세웅</h1>");
        body.append("<img src=\"cid:icon1.png\">");
        body.append("</body></html>");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(body.toString(), true);

        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:/upload/icon1.png"));
        mimeMessageHelper.addInline("icon1.png", fileSystemResource);

        fileSystemResource = new FileSystemResource(new File("C:/upload/spring.txt"));
        mimeMessageHelper.addAttachment("spring.txt", fileSystemResource);

        javaMailSender.send(mimeMessage);
    }
}














