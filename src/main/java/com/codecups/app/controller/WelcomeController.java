package com.codecups.app.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Copyright CodeCups
 * Created by Niko on 20 June 2021
 */

public class WelcomeController {

    @GetMapping(path = "/v0")
    public String wellcome() {
        return "Welcome to codecups!";
    }
}
