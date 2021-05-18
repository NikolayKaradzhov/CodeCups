package com.codecups.app.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 29 April 2021
 */

@Entity
@Getter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
