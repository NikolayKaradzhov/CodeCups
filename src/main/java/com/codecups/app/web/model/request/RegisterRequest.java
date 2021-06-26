package com.codecups.app.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright CodeCups
 * Created by Niko on 28 April 2021
 */

@Getter
@AllArgsConstructor
public class RegisterRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
//    private final AddressRequest address;
}
