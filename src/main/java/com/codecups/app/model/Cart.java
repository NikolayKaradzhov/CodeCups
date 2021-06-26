package com.codecups.app.model;

import javax.persistence.*;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */

@Entity(name = "carts")
public class Cart {

    @Id
    private long id;

    private String cartId;

    @ManyToMany
    @JoinTable(name = "carts_products",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")})
    private List<Product> products;

    @OneToOne
    private User user;

    private int quantity;

    private double totalPrice;
}
