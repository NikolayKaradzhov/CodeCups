package com.codecups.app.controller;

import com.codecups.app.service.ConfirmationTokenServiceImpl;
import com.codecups.app.web.model.request.RegisterRequest;
import com.codecups.app.service.RegistrationServiceImpl;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright CodeCups
 * Created by Niko on 15 April 2021
 */

@RestController
@RequestMapping(path = "/v0/registration") //http://localhost:8080/v0/registration
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationServiceImpl registrationServiceImpl;
    private final ConfirmationTokenServiceImpl confirmationTokenService;

    @PostMapping
    public ResponseEntity<Map<String, String>> signUp(@RequestBody RegisterRequest registerRequest) {
        Map<String, String> response = new HashMap<>();
        String token = registrationServiceImpl.register(registerRequest);

        response.put("Operation register", "success");
        response.put("Token: ", token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/confirm-registration")
    public ResponseEntity<String> confirm(@RequestParam("token") String token) {
        String response = confirmationTokenService.confirmToken(token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
