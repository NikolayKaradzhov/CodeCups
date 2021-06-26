package com.codecups.app.controller;

import com.codecups.app.dto.CartDto;
import com.codecups.app.dto.ProductDto;
import com.codecups.app.service.base.CartService;
import com.codecups.app.web.model.request.AddToCartRequest;
import com.codecups.app.web.model.response.CartRest;
import com.codecups.app.web.model.response.ProductRest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@RequestMapping(path = "/v0/cart/") //http://localhost:8080/v0/cart
public class CartController {

    private CartService cartService;

    @GetMapping(path = "{cartId}")
    public ResponseEntity<CartRest> getCart(@PathVariable String cartId) {
        return null;
    }

//    @PostMapping
//    public ResponseEntity<CartRest> addToCart(@RequestBody AddToCartRequest addtoCartRequest) {
//        CartDto cartDto = cartService.addToCartByProductId(addtoCartRequest.getProductId());
//
//        CartRest productRest = new ModelMapper().map(cartDto, CartRest.class);
//
//        return new ResponseEntity<>(productRest, HttpStatus.OK);
//    }
}
