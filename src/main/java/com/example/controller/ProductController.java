package com.example.controller;

import com.example.model.ProductPostgre;
import com.example.model.ProductRedis;
import com.example.repository.ProductPostgreRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController 
public class ProductController {

    @Autowired
    private ProductPostgreRepository productRepository;

    @Autowired
    private ProductService productService;

    // GET endpoint to fetch all products
    @GetMapping("/products")
    public List<ProductPostgre> getAllProducts() {
        return productRepository.findAll();
    }

    // POST endpoint to create a new product
    @PostMapping("/products")
    public ProductPostgre createProduct(@RequestBody ProductPostgre product) {
        return productRepository.save(product);
    }

    @PostMapping("/redis/save")
    public String saveToRedis(@RequestParam String key, @RequestParam String value) {
        productService.saveToRedis(key, value);
        return "Data saved to Redis with key: " + key;
    }

    // Retrieve data from Redis by key
    @GetMapping("/redis/get")
    public String getFromRedis(@RequestParam String key) {
        ProductRedis value = productService.getFromRedis(key);
        if (value == null) {
            return "No data found for key: " + key;
        }
        return "Value for key " + key + ": " + value.name;
    }
}