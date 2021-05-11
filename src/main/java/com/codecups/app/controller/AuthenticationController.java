package com.codecups.app.controller;

import com.codecups.app.security.util.JwtUtil;
import com.codecups.app.service.UserServiceImpl;
import com.codecups.app.web.model.request.AuthenticationRequest;
import com.codecups.app.web.model.response.AuthenticationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@RequestMapping(path = "v0/authenticate") //http://localhost:8080/v0/authenticate
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    JwtUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                                                                          authenticationRequest.getPassword()));
        } catch (BadCredentialsException bce) {
            throw new IllegalStateException("Incorrect username or password", bce);
        }

        final UserDetails userDetails = userServiceImpl.loadUserByUsername(authenticationRequest.getEmail());
        final String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}
