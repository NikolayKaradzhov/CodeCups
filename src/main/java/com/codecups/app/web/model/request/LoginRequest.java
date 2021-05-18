package com.codecups.app.web.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Copyright CodeCups
 * Created by Niko on 12 May 2021
 */

@Getter
@NoArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
