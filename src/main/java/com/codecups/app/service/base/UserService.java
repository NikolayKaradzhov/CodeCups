package com.codecups.app.service.base;

import com.codecups.app.dto.UserDto;

import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */
public interface UserService {
    void enableUser(String email);
    UserDto getUserByUserId(String id);
    void deleteByUserId(String id);
    List<UserDto> getUsers(int page, int limit);
}
