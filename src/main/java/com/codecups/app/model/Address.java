package com.codecups.app.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@Entity (name = "addresses")
@Getter
@Setter
public class Address implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -7941409005307374119L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 50, nullable = false)
    private String addressId;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 20, nullable = false)
    private String country;

    @Column(length = 100, nullable = false)
    private String streetName;

    @Column(length = 4, nullable = false)
    private String postalCode;

    @Column(length = 10, nullable = false)
    private String type;
}
