package com.codecups.app.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Copyright CodeCups
 * Created by Niko on 05 May 2021
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
}
