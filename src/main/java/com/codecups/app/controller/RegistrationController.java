package com.codecups.app.controller;

import com.codecups.app.web.model.request.UserRegistrationRequest;
import com.codecups.app.service.RegistrationServiceImpl;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright CodeCups
 * Created by Niko on 15 April 2021
 */
@RestController
@RequestMapping(path = "v0/registration") //http://localhost:8080/v0/registration
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationServiceImpl registrationServiceImpl;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        String token = registrationServiceImpl.register(userRegistrationRequest);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationServiceImpl.confirmToken(token);
    }
}
