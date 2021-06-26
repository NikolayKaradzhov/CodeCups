package com.codecups.app.dto;

import com.codecups.app.model.Product;

import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */
public class CartDto {

    private String cartId;
    private String cart_id;
    private List<ProductDto> products;
    private UserDto user;
    private int quantity;
    private double totalPrice;
}
