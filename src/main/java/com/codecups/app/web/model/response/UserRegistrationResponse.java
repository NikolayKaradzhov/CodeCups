package com.codecups.app.web.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Copyright CodeCups
 * Created by Niko on 10 May 2021
 */

@Getter
@NoArgsConstructor
public class UserRegistrationResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
