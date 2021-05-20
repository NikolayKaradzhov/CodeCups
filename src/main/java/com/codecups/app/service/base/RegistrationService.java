package com.codecups.app.service.base;

import com.codecups.app.web.model.request.RegisterRequest;

/**
 * Copyright CodeCups
 * Created by Niko on 20 May 2021
 */
public interface RegistrationService {
    String register(RegisterRequest registerRequest);
}
