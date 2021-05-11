package com.codecups.app.service.base;

import com.codecups.app.dto.UserDto;
import com.codecups.app.web.model.response.HttpResponse;


/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */
public interface UserService {
    HttpResponse register(UserDto user);

    void enableUser(String email);
}
