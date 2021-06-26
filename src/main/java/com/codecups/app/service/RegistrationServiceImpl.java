package com.codecups.app.service;

import com.codecups.app.email.EmailSender;
import com.codecups.app.email.EmailValidator;
import com.codecups.app.email.MailConstant;
import com.codecups.app.model.Address;
import com.codecups.app.model.ConfirmationToken;
import com.codecups.app.model.User;
import com.codecups.app.repository.UserRepository;
import com.codecups.app.security.util.PublicIdGenerator;
import com.codecups.app.service.base.ConfirmationTokenService;
import com.codecups.app.service.base.RegistrationService;
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
public class RegistrationServiceImpl implements RegistrationService {

    private final ConfirmationTokenService confirmationTokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailValidator emailValidator;
    private final UserRepository userRepository;
    private final EmailSender mailSender;
    private final PublicIdGenerator publicIdGenerator;

    @Override
    public String register(RegisterRequest registerRequest) {

        boolean isValidEmail = emailValidator.test(registerRequest.getEmail());

        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        String token = signUpUser(registerRequest);

        mailSender.send(registerRequest.getEmail(),
                MailConstant.buildRegistrationEmail(registerRequest.getFirstName(), MailConstant.TOKEN_CONFIRMATION_LINK + token));

        return token;
    }

    private String signUpUser(RegisterRequest registerRequest) {
        boolean isUserExists = userRepository
                .findByEmail(registerRequest.getEmail())
                .isPresent();

        if (isUserExists) {
            //TODO: if email not confirmed, send confirmation link again

            throw new RuntimeException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(registerRequest.getPassword());

        String publicUserId = publicIdGenerator.generateRandomString(30);
        User user = new User();
        user.setUserId(publicUserId);
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodedPassword);
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setCreatedAt(LocalDateTime.now());

//        Address address = new Address();
//        address.setAddressId(publicIdGenerator.generateRandomString(30));
//        address.setCountry(registerRequest.getAddress().getCountry());
//        address.setCity(registerRequest.getAddress().getCity());
//        address.setStreetName(registerRequest.getAddress().getStreet());
//        address.setPostalCode(registerRequest.getAddress().getPostalCode());
//        address.setStreetNumber(registerRequest.getAddress().getStreetNumber());
//        user.setAddress(address);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }
}
