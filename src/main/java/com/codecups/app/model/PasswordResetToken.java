package com.codecups.app.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Copyright CodeCups
 * Created by Niko on 16 May 2021
 */

@Entity(name = "password_reset_tokens")
@Getter
@Setter
public class PasswordResetToken implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 6872793624334195034L;

    @Id
    @GeneratedValue
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private LocalDateTime resetAt;
}
