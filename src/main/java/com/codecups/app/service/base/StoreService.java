package com.codecups.app.service.base;

import com.codecups.app.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */
public interface StoreService {
    List<Product> getAll();

    Optional<Product> findById(Long productId);

    Product findByName(String productName);

    void delete(Long productId);
}
