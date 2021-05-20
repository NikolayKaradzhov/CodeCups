package com.codecups.app.service;

import com.codecups.app.dto.OrderDto;
import com.codecups.app.model.Order;
import com.codecups.app.repository.OrderRepository;
import com.codecups.app.service.base.OrderService;
import com.codecups.app.web.model.request.OrderRequest;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 20 May 2021
 */

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getOrders(int page, int limit) {
        List<OrderDto> returnedOrders = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Order> productPage = orderRepository.findAll(pageableRequest);
        List<Order> orders = productPage.getContent();

        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order, orderDto);
            returnedOrders.add(orderDto);
        }

        log.info("IN getOrders() - orders loaded successfully");

        return returnedOrders;
    }

    @Override
    public OrderDto getOrder(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);

        OrderDto orderDto = new OrderDto();

        BeanUtils.copyProperties(order, orderDto);

        log.info("IN getOrder() - order with id {} loaded successfully", orderId);

        return orderDto;
    }

    @Override
    public void updateOrder(OrderRequest orderRequest) {

    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        orderRepository.delete(order);

        log.info("IN deleteOrder() - order with id {} deleted successfully", orderId);
    }

    @Override
    public void createOrder(OrderRequest orderRequest) {

    }
}
