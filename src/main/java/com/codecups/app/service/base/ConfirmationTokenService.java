package com.codecups.app.service.base;

import com.codecups.app.model.ConfirmationToken;

import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */
public interface ConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken token);
}