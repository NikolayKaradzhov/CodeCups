package com.codecups.app.web.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright CodeCups
 * Created by Niko on 18 May 2021
 */

@Getter
@Setter
public class UserRest {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private AddressRest address;
}
