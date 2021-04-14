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

@Entity (name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;
}
