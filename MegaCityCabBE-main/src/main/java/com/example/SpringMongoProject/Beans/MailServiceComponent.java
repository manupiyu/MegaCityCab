package com.example.SpringMongoProject.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendSimpleMessage(String to, String subject, String text) {

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("rasnisiriwardana@gmail.com");
            msg.setTo(to);
            msg.setSubject(subject);
            msg.setText(text);
            javaMailSender.send(msg);
        } catch (Exception e) {
            return false;
        }
        return true;

    }
}
