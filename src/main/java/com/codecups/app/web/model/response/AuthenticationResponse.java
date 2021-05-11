package com.codecups.app.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright CodeCups
 * Created by Niko on 05 May 2021
 */

@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String jwt;
}
