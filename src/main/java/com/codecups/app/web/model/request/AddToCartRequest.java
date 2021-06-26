package com.codecups.app.web.model.request;

import com.codecups.app.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright CodeCups
 * Created by Niko on 20 June 2021
 */

@Getter
@AllArgsConstructor
public class AddToCartRequest {
    private final Product product;
}
