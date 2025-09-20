package com.JobApplicationPortal.JobApplicationPortal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Our Platform!");
        message.setText(" Thank you for registering. Explore jobs and get started.!");
        message.setFrom("JohnBhaiemail@gmail.com");
        mailSender.send(message);
    }

    public void sendSelection(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Congratulations!");
        message.setText("You Are Selected");
        message.setFrom("JohnBhaiemail@gmail.com");
        mailSender.send(message);
    }
}
