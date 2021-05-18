package com.codecups.app.email;

/**
 * Copyright CodeCups
 * Created by Niko on 30 April 2021
 */

public interface EmailSender {
    void send(String to, String email);
}
