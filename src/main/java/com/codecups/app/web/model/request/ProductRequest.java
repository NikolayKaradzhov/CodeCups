package com.codecups.app.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */

@Getter
@AllArgsConstructor
public class ProductRequest {
    private String name;

    private String description;

    private double price;

    private String image;
}
