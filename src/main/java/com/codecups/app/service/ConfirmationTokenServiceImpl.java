package com.codecups.app.service;

import com.codecups.app.model.ConfirmationToken;
import com.codecups.app.repository.ConfirmationTokenRepository;

import com.codecups.app.service.base.ConfirmationTokenService;
import com.codecups.app.service.base.UserService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 29 April 2021
 */

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final UserService userService;

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = getConfirmationToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed.");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token already expired.");
        }

        setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());

        return "Token Confirmed. Account Activated Successfully";
    }

    @Override
    public void saveConfirmationTokenToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getConfirmationToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmedAt(String token){
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        confirmationToken.setConfirmedAt(LocalDateTime.now());

        confirmationTokenRepository.save(confirmationToken);
    }
}
