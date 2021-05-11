package com.codecups.app.service.base;

import com.codecups.app.model.ConfirmationToken;
import com.codecups.app.web.model.response.HttpResponse;

import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */
public interface ConfirmationTokenService {
    void save(ConfirmationToken token);

    Optional<ConfirmationToken> getToken(String token);

    void setConfirmedAt(String token);

    HttpResponse confirmToken(String token);
}
