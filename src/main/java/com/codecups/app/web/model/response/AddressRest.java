package com.codecups.app.web.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */

@Getter
@Setter
public class AddressRest {
    private String addressId;
    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postalCode;
}
