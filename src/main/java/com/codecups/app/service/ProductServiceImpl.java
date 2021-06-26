package com.codecups.app.service;

import com.codecups.app.dto.ProductDto;
import com.codecups.app.model.Product;
import com.codecups.app.repository.ProductRepository;
import com.codecups.app.security.util.PublicIdGenerator;
import com.codecups.app.service.base.ProductService;
import com.codecups.app.web.model.request.ProductRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 03 May 2021
 */

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PublicIdGenerator publicIdGenerator;

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

        log.info("IN getProducts() - products loaded successfully");

        return returnedProducts;
    }

    @Override
    public ProductDto addProduct(ProductRequest productRequest) {
        Product product = new Product();

        String publicProductId = publicIdGenerator.generateRandomString(30);

        product.setProductId(publicProductId);
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setImage(productRequest.getImage());

        productRepository.save(product);
        ProductDto productDto = new ModelMapper().map(product, ProductDto.class);

        log.info("IN addProduct() - product with id: {} added successfully", publicProductId);

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        ProductDto returnedProduct = new ModelMapper().map(product, ProductDto.class);

        log.info("IN getProduct() - product with id: {} found", product.getProductId());
        return returnedProduct;
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {

    }

    @Override
    public void deleteProduct(String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        productRepository.delete(product);

        log.info("IN deleteProduct() - product {} deleted successfully", product.getName());
    }
}
