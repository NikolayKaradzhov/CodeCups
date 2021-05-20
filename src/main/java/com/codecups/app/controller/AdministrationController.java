package com.codecups.app.controller;

import com.codecups.app.dto.OrderDto;
import com.codecups.app.dto.ProductDto;
import com.codecups.app.dto.UserDto;
import com.codecups.app.service.base.OrderService;
import com.codecups.app.service.base.ProductService;
import com.codecups.app.service.base.UserService;
import com.codecups.app.web.enums.RequestOperationName;
import com.codecups.app.web.enums.RequestOperationStatus;
import com.codecups.app.web.model.request.OrderRequest;
import com.codecups.app.web.model.request.ProductRequest;

import com.codecups.app.web.model.response.OperationStatus;
import com.codecups.app.web.model.response.OrderRest;
import com.codecups.app.web.model.response.ProductRest;
import com.codecups.app.web.model.response.UserRest;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v0/administration") //http://localhost:8080/v0/administration
public class AdministrationController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    //USERS
    @GetMapping(path = "/users")
    public ResponseEntity<List<UserRest>> getAllUsers(@RequestParam (value = "page", defaultValue = "1") int page,
                                      @RequestParam (value = "limit", defaultValue = "25") int limit) {
        List<UserRest> returnedUsers = new ArrayList<>();
        List<UserDto> users = userService.getUsers(page, limit);

        for (UserDto userDto : users) {
            UserRest userModel = new UserRest();
            BeanUtils.copyProperties(userDto, userModel);
            returnedUsers.add(userModel);
        }

        return new ResponseEntity<>(returnedUsers, HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<UserRest> getUser(@PathVariable (name = "userId") String userId) {
        UserRest returnedUser = new UserRest();

        UserDto userDto = userService.getUserByUserId(userId);
        BeanUtils.copyProperties(userDto, returnedUser);

        return new ResponseEntity<>(returnedUser, HttpStatus.OK);
    }

//    @PutMapping(path = "/users/{userId}")
//    public String updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
//        return "updateUser() was called";
//    }

    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<OperationStatus> deleteUser(@PathVariable String userId) {
        OperationStatus returnValue = new OperationStatus();

        returnValue.setOperationName(RequestOperationName.DELETE.name());

        userService.deleteByUserId(userId);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    //ORDERS
    @GetMapping(path = "/orders")
    public ResponseEntity<List<OrderRest>> getAllOrders(@RequestParam (value = "page", defaultValue = "1") int page,
                                                        @RequestParam (value = "limit", defaultValue = "25") int limit) {

        List<OrderRest> returnedOrders = new ArrayList<>();
        List<OrderDto> orders = orderService.getOrders(page, limit);

        for (OrderDto orderDto : orders) {
            OrderRest order = new OrderRest();
            BeanUtils.copyProperties(orderDto, order);
            returnedOrders.add(order);
        }

        return new ResponseEntity<>(returnedOrders, HttpStatus.OK);
    }

    @GetMapping(path = "/orders/{orderId}")
    public ResponseEntity<OrderRest> getOrder(@PathVariable String orderId) {
        OrderRest returnedOrder = new OrderRest();
        OrderDto orderDto = orderService.getOrder(orderId);

        BeanUtils.copyProperties(orderDto, returnedOrder);

        return new ResponseEntity<>(returnedOrder, HttpStatus.OK);
    }

    @PutMapping(path = "/orders/{orderId}")
    public ResponseEntity<OperationStatus> updateOrder(@PathVariable Long orderId, @RequestBody OrderRequest orderRequest) {
        OperationStatus returnValue = new OperationStatus();
        returnValue.setOperationName(RequestOperationName.UPDATE.name());

        orderService.updateOrder(orderRequest);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @DeleteMapping(path = "/orders/{orderId}")
    public ResponseEntity<OperationStatus> deleteOrder(@PathVariable String orderId) {
        OperationStatus returnValue = new OperationStatus();

        returnValue.setOperationName(RequestOperationName.DELETE.name());

        orderService.deleteOrder(orderId);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    //PRODUCTS
    @PostMapping(path = "/products/add/")
    public ResponseEntity<ProductRest> addProduct(@RequestBody ProductRequest product) {
        ProductRest productResponse = new ProductRest();

        ProductDto productDto = productService.addProduct(product);

        BeanUtils.copyProperties(productDto, productResponse);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductRest>> getAllProducts(@RequestParam (value = "page", defaultValue = "1") int page,
                                                        @RequestParam (value = "limit", defaultValue = "25") int limit) {

        List<ProductRest> returnedProducts = new ArrayList<>();
        List<ProductDto> products = productService.getProducts(page, limit);

        for (ProductDto productDto : products) {
            ProductRest productResponseModel = new ProductRest();
            BeanUtils.copyProperties(productDto, productResponseModel);
            returnedProducts.add(productResponseModel);
        }

        return new ResponseEntity<>(returnedProducts, HttpStatus.OK);
    }

    @GetMapping(path = "/products/{productId}")
    public ResponseEntity<ProductRest> getProduct(@PathVariable String productId) {
        ProductRest productResponse = new ProductRest();
        ProductDto productDto = productService.getProduct(productId);

        BeanUtils.copyProperties(productDto, productResponse);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping(path = "/products/{productId}")
    public ResponseEntity<OperationStatus> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {
        OperationStatus returnValue = new OperationStatus();
        returnValue.setOperationName(RequestOperationName.UPDATE.name());

        productService.updateProduct(productRequest);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @DeleteMapping(path = "/products/{productId}")
    public ResponseEntity<OperationStatus> deleteProduct(@PathVariable String productId) {
        OperationStatus returnValue = new OperationStatus();

        returnValue.setOperationName(RequestOperationName.DELETE.name());

        productService.deleteProduct(productId);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}
