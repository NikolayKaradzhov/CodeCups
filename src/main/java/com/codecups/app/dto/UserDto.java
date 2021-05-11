package com.codecups.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */

@Getter
@Setter
public class UserDto implements Serializable {
    private static final long serialVersionUID = 4273990919130389143L;

    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private boolean enabled;
    private boolean locked;
}
