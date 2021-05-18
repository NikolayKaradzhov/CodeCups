package com.codecups.app.service;

import com.codecups.app.dto.ProductDto;
import com.codecups.app.dto.UserDto;
import com.codecups.app.model.Product;
import com.codecups.app.model.User;
import com.codecups.app.repository.ProductRepository;
import com.codecups.app.service.base.StoreService;

import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ProductDto> getProducts(int page, int limit) {
        List<ProductDto> returnedProducts = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Product> productPage = productRepository.findAll(pageableRequest);
        List<Product> products = productPage.getContent();

        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            returnedProducts.add(productDto);
        }

        return returnedProducts;
    }
}
