package com.codecups.app.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */

@Getter
@AllArgsConstructor
public class AddressRequest {
    private final String country;
    private final String city;
    private final String street;
    private final int streetNumber;
    private final String telephone;
    private final String postalCode;
}
