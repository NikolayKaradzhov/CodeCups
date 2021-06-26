package com.codecups.app.service.base;

import com.codecups.app.dto.CartDto;
import com.codecups.app.web.model.request.AddToCartRequest;

import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */
public interface CartService {
    List<CartDto> addToCartByUserIdAndProductId(String userId, String productId);
    CartDto getCartByUserId(String userId);
    void removeCartByUserId(String userId);

    CartDto addToCartByProductId(AddToCartRequest addtoCartRequest);
    //checkoutCart()
}
