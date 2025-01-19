package com.example.controller;

import com.example.model.ProductPostgre;
import com.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductPostgre product) {
        try {
            productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to create product: " + e.getMessage());
        }
    }
}