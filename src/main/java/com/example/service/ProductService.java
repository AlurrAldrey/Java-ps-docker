package com.example.service;

import com.example.model.ProductRedis;
import com.example.repository.ProductPostgreRepository;
import com.example.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.ProductPostgre;


@Service
public class ProductService {

    @Autowired
    private ProductRedisRepository productRedisRepository;

    @Autowired
    private ProductPostgreRepository productPostgreRepository;

    public void saveProduct(ProductPostgre product) {
        productPostgreRepository.save(product);
    }
}