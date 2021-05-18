package com.codecups.app.controller;

import com.codecups.app.dto.ProductDto;
import com.codecups.app.dto.UserDto;
import com.codecups.app.model.Product;
import com.codecups.app.service.base.StoreService;
import com.codecups.app.service.base.UserService;
import com.codecups.app.web.enums.RequestOperationName;
import com.codecups.app.web.enums.RequestOperationStatus;
import com.codecups.app.web.model.request.OrderRequest;
import com.codecups.app.web.model.request.ProductRequest;
import com.codecups.app.web.model.request.UserRequest;

import com.codecups.app.web.model.response.OperationStatus;
import com.codecups.app.web.model.response.ProductRest;
import com.codecups.app.web.model.response.UserRest;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v0/administration") //http://localhost:8080/v0/administration
public class AdministrationController {

    private final UserService userService;
    private final StoreService productService;

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

    @PutMapping(path = "/users/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        return "updateUser() was called";
    }

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
    public String getAllOrders(@RequestParam (value = "page", defaultValue = "1") int page,
                               @RequestParam (value = "limit", defaultValue = "25") int limit) {

        return "getAllOrders called";
    }

    @GetMapping(path = "/orders/{orderId}")
    public String getOrder() {
        return "getOrder() was called";
    }

    @PutMapping(path = "/orders/{orderId}")
    public String updateOrder(@PathVariable Long orderId, @RequestBody OrderRequest orderRequest) {
        return "updateOrder() was called";
    }

    @DeleteMapping(path = "/orders/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        return "deleteOrder() was called";
    }

    //PRODUCTS
    @PostMapping(path = "/products/add/")
    public String addProduct(@RequestBody ProductRequest product) {
        return "addProduct() was called";
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
    public String getProduct(@PathVariable Long productId) {
        return "getProduct called";
    }

    @PutMapping(path = "/products/{productId}")
    public String updateProduct(@PathVariable Long productId, @RequestBody OrderRequest productRequest) {
        return "updateProduct() was called";
    }

    @DeleteMapping(path = "/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {

        return "deleted";
    }
}
