package com.codecups.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@Entity (name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    private String image;
}


