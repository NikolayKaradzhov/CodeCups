package com.codecups.app.repository;

import com.codecups.app.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 15 April 2021
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long orderId);
}
