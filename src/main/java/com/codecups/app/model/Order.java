package com.codecups.app.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@Entity (name = "orders")
@Getter
@Setter
public class Order implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -5092921365192592071L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
