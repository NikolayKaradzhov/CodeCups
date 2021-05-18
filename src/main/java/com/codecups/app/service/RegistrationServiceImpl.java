package com.codecups.app.service;

import com.codecups.app.email.EmailSender;
import com.codecups.app.email.EmailValidator;
import com.codecups.app.email.MailConstant;
import com.codecups.app.model.ConfirmationToken;
import com.codecups.app.model.User;
import com.codecups.app.repository.UserRepository;
import com.codecups.app.security.util.PublicIdGenerator;
import com.codecups.app.service.base.ConfirmationTokenService;
import com.codecups.app.web.model.request.RegisterRequest;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Copyright CodeCups
 * Created by Niko on 28 April 2021
 */

@Service
@AllArgsConstructor
public class RegistrationServiceImpl {

    private final ConfirmationTokenService confirmationTokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailValidator emailValidator;
    private final UserRepository userRepository;
    private final EmailSender mailSender;
    private final PublicIdGenerator publicIdGenerator;

    public String register(RegisterRequest registerRequest) {

        boolean isValidEmail = emailValidator.test(registerRequest.getEmail());

        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        String token = signUpUser(new User(registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getPassword()));

        mailSender.send(registerRequest.getEmail(),
                MailConstant.buildRegistrationEmail(registerRequest.getFirstName(), MailConstant.TOKEN_CONFIRMATION_LINK + token));

        return token;
    }

    private String signUpUser(User user) {
        boolean isUserExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (isUserExists) {
            //TODO: if email not confirmed, send confirmation link again

            throw new RuntimeException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());

        String publicUserId = publicIdGenerator.generateUserId(30);
        user.setUserId(publicUserId);
        user.setPassword(encodedPassword);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user);

        confirmationTokenService.saveConfirmationTokenToken(confirmationToken);

        return token;
    }
}
