package com.example.controller;

import com.example.model.Product;
import com.example.model.ProductRedis;
import com.example.repository.ProductRepository;
import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController 
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RedisService redisService;

    // GET endpoint to fetch all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // POST endpoint to create a new product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/redis/save")
    public String saveToRedis(@RequestParam String key, @RequestParam String value) {
        redisService.saveToRedis(key, value);
        return "Data saved to Redis with key: " + key;
    }

    // Retrieve data from Redis by key
    @GetMapping("/redis/get")
    public String getFromRedis(@RequestParam String key) {
        ProductRedis value = redisService.getFromRedis(key);
        if (value == null) {
            return "No data found for key: " + key;
        }
        return "Value for key " + key + ": " + value.name;
    }
}