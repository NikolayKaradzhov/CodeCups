package com.codecups.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */

@Getter
@NoArgsConstructor
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1083866052624381879L;

    private String name;
    private String description;
    private double price;
    private String image;
}
