package com.codecups.app.repository;

import com.codecups.app.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright CodeCups
 * Created by Niko on 15 April 2021
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String productName);
}