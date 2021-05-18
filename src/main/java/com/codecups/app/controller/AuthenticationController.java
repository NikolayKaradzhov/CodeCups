package com.codecups.app.controller;

import com.codecups.app.service.AuthenticationService;
import com.codecups.app.web.enums.RequestOperationName;
import com.codecups.app.web.enums.RequestOperationStatus;
import com.codecups.app.web.model.request.LoginRequest;
import com.codecups.app.web.model.request.PasswordResetRequest;
import com.codecups.app.web.model.response.AuthenticationResponse;

import com.codecups.app.web.model.response.OperationStatus;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v0/authenticate") //http://localhost:8080/v0/authenticate
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.login(loginRequest);

        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/password-reset")
    public ResponseEntity<OperationStatus> passwordReset(@RequestBody PasswordResetRequest passwordResetRequest) {
        OperationStatus returnValue = new OperationStatus();

        boolean operationResult = authenticationService.resetPassword(passwordResetRequest);

        returnValue.setOperationName(RequestOperationName.REQUEST_PASSWORD_RESET.name());
        returnValue.setOperationResult(RequestOperationStatus.ERROR.name());

        if (operationResult) {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        }

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}
