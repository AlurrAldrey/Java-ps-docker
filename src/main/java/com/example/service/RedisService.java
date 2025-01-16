package com.example.service;

import com.example.model.ProductRedis;
import com.example.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private ProductRedisRepository productRedisRepository;

    // Save product to Redis
    public void saveToRedis(String key, String name) {
        ProductRedis product = new ProductRedis();
        product.setId(key);
        product.setName(name);
        productRedisRepository.save(product);
    }

    // Retrieve product from Redis by key
    public ProductRedis getFromRedis(String key) {
        return productRedisRepository.findById(key).orElse(null);
    }
}