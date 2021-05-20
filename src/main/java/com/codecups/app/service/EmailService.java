package com.codecups.app.service;

import com.codecups.app.email.EmailSender;
import com.codecups.app.email.MailConstant;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Copyright CodeCups
 * Created by Niko on 30 April 2021
 */

@Service
@Slf4j
@AllArgsConstructor
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = prepareMimeMessage(to, email);
            mailSender.send(mimeMessage);
            log.info("Mail sent successfully");
        } catch (MessagingException me) {
            log.error("Failed to send email", me);
            throw new IllegalStateException("Sending email failed");
        }
    }

    private MimeMessage prepareMimeMessage(String to, String email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MailConstant.EMAIL_ENCODING);

        messageHelper.setText(email, true);
        messageHelper.setTo(to);
        if (email.contains("Registration")) {
            messageHelper.setSubject(MailConstant.CONFIRM_EMAIL_SUBJECT);
        } else {
            messageHelper.setSubject(MailConstant.PASSWORD_RESET_SUBJECT);
        }

        messageHelper.setFrom(MailConstant.SENDER);

        return mimeMessage;
    }
}
