package com.codecups.app.controller;

import com.codecups.app.model.Product;
import com.codecups.app.service.base.StoreService;
import com.codecups.app.service.base.UserService;
import com.codecups.app.web.model.request.OrderRequest;
import com.codecups.app.web.model.request.ProductRequest;
import com.codecups.app.web.model.request.UserRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Copyright CodeCups
 * Created by Niko on 14 April 2021
 */

@RestController
@RequestMapping(path = "v0/administration") //http://localhost:8080/v0/administration
public class AdministrationController {

    private UserService userService;
    private StoreService productService;


    //USERS
    @GetMapping(path = "/users")
    public String getAllUsers() {
        return "getAllUsers() was called";
    }

    @GetMapping(path = "/users/{userId}")
    public String getUser(@PathVariable (name = "userId") Long userId) {
        return "getUser() was called";
    }

    @PutMapping(path = "/users/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        return "updateUser() was called";
    }

    @DeleteMapping(path = "/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return "deleteUser was called";
    }

    //ORDERS
    @GetMapping(path = "/orders")
    public String getAllOrders() {
        return "getAllOrders() was called";
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
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/products/{productId}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long productId) {
        Optional<Product> product = productService.findById(productId);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(path = "/products/{productId}")
    public String updateProduct(@PathVariable Long productId, @RequestBody OrderRequest productRequest) {
        return "updateProduct() was called";
    }

    @DeleteMapping(path = "/products/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);

        return "deleted";
    }
}
