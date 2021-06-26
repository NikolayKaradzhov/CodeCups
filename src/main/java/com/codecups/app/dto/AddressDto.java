package com.codecups.app.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright CodeCups
 * Created by Niko on 18 May 2021
 */

@Getter
@Setter
public class AddressDto {

    private long id;
    private String addressId;
    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postalCode;
}