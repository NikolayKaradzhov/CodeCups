package com.codecups.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@Entity (name = "addresses")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String country;

    private String city;

    private String streetName;

    private String streetNumber;

    private String postalCode;
}
