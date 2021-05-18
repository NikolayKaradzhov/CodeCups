package com.codecups.app.service;

import com.codecups.app.dto.UserDto;
import com.codecups.app.model.User;
import com.codecups.app.repository.UserRepository;
import com.codecups.app.service.base.UserService;

import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 16 May 2021
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void enableUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        user.setEnabled(true);

        userRepository.save(user);
    }

    @Override
    public UserDto getUserByUserId(String id) {
        UserDto returnedUser = new UserDto();

        User user = userRepository
                .findByUserId(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        BeanUtils.copyProperties(user, returnedUser);
        return returnedUser;
    }

    @Override
    public void deleteByUserId(String id) {
        User user = userRepository
                .findByUserId(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        List<UserDto> returnedUsers = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<User> usersPage = userRepository.findAll(pageableRequest);
        List<User> users = usersPage.getContent();

        for (User user : users) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            returnedUsers.add(userDto);
        }

        return returnedUsers;
    }
}
