package com.codecups.app.service;

import com.codecups.app.model.Product;
import com.codecups.app.repository.ProductRepository;
import com.codecups.app.service.base.StoreService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 03 May 2021
 */

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    @Autowired
    private final ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product findByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
}
