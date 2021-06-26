package com.codecups.app.service;

import com.codecups.app.dto.CartDto;
import com.codecups.app.model.Cart;
import com.codecups.app.repository.CartRepository;
import com.codecups.app.service.base.CartService;

import com.codecups.app.web.model.request.AddToCartRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */

@AllArgsConstructor
public class CartServiceImpl implements CartService {

    public final CartRepository cartRepository;

    @Override
    public List<CartDto> addToCartByUserIdAndProductId(String userId, String productId) {
        Cart cart = cartRepository.getCartByUserId(userId);
        return null;
    }

    @Override
    public CartDto getCartByUserId(String userId) {
        Cart cart = cartRepository.getCartByUserId(userId);
        return new ModelMapper().map(cart, CartDto.class);
    }

    @Override
    public void removeCartByUserId(String userId) {
        Cart cart = cartRepository.getCartByUserId(userId);
        cartRepository.delete(cart);
    }

    @Override
    public CartDto addToCartByProductId(AddToCartRequest addtoCartRequest) {
        return null;
    }
}
