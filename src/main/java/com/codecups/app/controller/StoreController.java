package com.codecups.app.controller;

import com.codecups.app.dto.ProductDto;
import com.codecups.app.service.base.ProductService;
import com.codecups.app.web.model.response.ProductRest;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@RequestMapping(path = "/v0/store") //http://localhost:8080/v0/store
@AllArgsConstructor
public class StoreController {

    private final ProductService productService;

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductRest>> getAllProducts(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam (value = "limit", defaultValue = "25") int limit) {

        List<ProductRest> returnedProducts = new ArrayList<>();
        List<ProductDto> products = productService.getProducts(page, limit);
        ModelMapper modelMapper = new ModelMapper();

        for (ProductDto productDto : products) {
            ProductRest productRest = modelMapper.map(productDto, ProductRest.class);
            returnedProducts.add(productRest);
        }

        return new ResponseEntity<>(returnedProducts, HttpStatus.OK);
    }

    @GetMapping(path = "/products/{productId}")
    public ResponseEntity<ProductRest> getProduct(@PathVariable String productId) {
        ProductDto productDto = productService.getProduct(productId);
        ProductRest productRest = new ModelMapper().map(productDto, ProductRest.class);

        return new ResponseEntity<>(productRest, HttpStatus.OK);
    }
}
