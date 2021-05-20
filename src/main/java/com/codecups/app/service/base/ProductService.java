package com.codecups.app.service.base;

import com.codecups.app.dto.ProductDto;
import com.codecups.app.model.Product;
import com.codecups.app.web.model.request.OrderRequest;
import com.codecups.app.web.model.request.ProductRequest;

import java.util.List;
import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 06 May 2021
 */
public interface ProductService {
    List<ProductDto> getProducts(int page, int limit);

    ProductDto addProduct(ProductRequest product);

    ProductDto getProduct(String productId);

    void updateProduct(ProductRequest productRequest);

    void deleteProduct(String productId);
}
