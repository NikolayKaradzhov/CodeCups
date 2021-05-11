package com.codecups.app.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * Copyright CodeCups
 * Created by Niko on 29 April 2021
 */

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {

        //TODO: Regex to validate email
        return true;
    }
}
