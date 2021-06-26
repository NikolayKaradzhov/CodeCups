package com.codecups.app.web.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright CodeCups
 * Created by Niko on 18 May 2021
 */

@Getter
@Setter
public class ProductRest {
    private String productId;
    private String name;
    private String description;
    private double price;
    private String image;
}
