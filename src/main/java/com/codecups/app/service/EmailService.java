package com.codecups.app.service;

import com.codecups.app.email.EmailSender;
import com.codecups.app.email.MailConstant;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@AllArgsConstructor
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = prepareMimeMessage(to, email);
            mailSender.send(mimeMessage);
        } catch (MessagingException me) {
            LOGGER.error("Failed to send email", me);
            throw new IllegalStateException("Sending email failed");
        }
    }

    private MimeMessage prepareMimeMessage(String to, String email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

        messageHelper.setText(email, true);
        messageHelper.setTo(to);
        messageHelper.setSubject(MailConstant.EMAIL_SUBJECT);
        messageHelper.setFrom(MailConstant.SENDER);

        return mimeMessage;
    }
}
