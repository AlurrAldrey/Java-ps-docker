package com.example.service;

import com.example.model.ProductRedis;
import com.example.repository.ProductPostgreRepository;
import com.example.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRedisRepository productRedisRepository;

    @Autowired
    private ProductPostgreRepository productPostgreRepository;

    public void saveToRedis(String key, String name) {

        //For testing:
        productPostgreRepository.findAll();

        ProductRedis product = new ProductRedis();
        product.setId(key);
        product.setName(name);
        productRedisRepository.save(product);
    }

    public ProductRedis getFromRedis(String key) {
        return productRedisRepository.findById(key).orElse(null);
    }
}