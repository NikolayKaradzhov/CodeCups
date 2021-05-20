package com.codecups.app.service;

import com.codecups.app.email.EmailSender;
import com.codecups.app.email.MailConstant;
import com.codecups.app.model.PasswordResetToken;
import com.codecups.app.model.User;
import com.codecups.app.repository.PasswordResetTokenRepository;
import com.codecups.app.repository.UserRepository;
import com.codecups.app.security.util.JwtUtil;
import com.codecups.app.web.model.request.LoginRequest;
import com.codecups.app.web.model.request.PasswordResetRequest;
import com.codecups.app.web.model.response.AuthenticationResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Copyright CodeCups
 * Created by Niko on 12 May 2021
 */

@Slf4j
@Service
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userService;
    private final JwtUtil jwtUtil;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserRepository userRepository;
    private final EmailSender mailSender;

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authentication;

        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
        } catch (BadCredentialsException bce) {
            log.error("IN login() - Incorrect username or password");
            throw new RuntimeException("Bad credentials. Invalid username or password");
        }


        SecurityContextHolder.getContext().setAuthentication(authentication);
        //final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        User user = userRepository
                .findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        //TODO Throw exception if user is has not confirmed token after registration
        if (!user.isEnabled()) {
            log.info("IN login() - User {} is not enabled", user.getEmail());
            throw new RuntimeException("Account not confirmed. Please confirm your registration.");
        }

        final String token = jwtUtil.generateToken(user);

        return new AuthenticationResponse(token, loginRequest.getEmail());
    }

    public boolean resetPassword(PasswordResetRequest passwordResetRequest) {
        User user = userRepository
                .findByEmail(passwordResetRequest.getEmail())
                .orElseThrow(() -> new IllegalStateException("Email does not exists."));

        if (user == null) {
            return false;
        }

        String token = jwtUtil.generateToken(user);

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setUser(user);
        passwordResetTokenRepository.save(passwordResetToken);

        mailSender.send(passwordResetRequest.getEmail(),
                MailConstant.buildPasswordResetEmail(user.getFirstName(), MailConstant.TOKEN_CONFIRMATION_LINK + token));
        log.info("IN resetPassword() - Password reset email sent successfully");

        return true;
    }
}
