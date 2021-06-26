package com.codecups.app.repository;

import com.codecups.app.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright CodeCups
 * Created by Niko on 02 June 2021
 */

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart getCartByUserId(String userId);
    void deleteCartByCartIdAndUserId(String cartId, String userId);
}
