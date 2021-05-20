package com.codecups.app.service.base;

import com.codecups.app.dto.OrderDto;
import com.codecups.app.web.model.request.OrderRequest;

import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 20 May 2021
 */

public interface OrderService {
    List<OrderDto> getOrders(int page, int limit);

    OrderDto getOrder(String orderId);

    void updateOrder(OrderRequest orderRequest);

    void deleteOrder(String orderId);

    void createOrder(OrderRequest orderRequest);
}
