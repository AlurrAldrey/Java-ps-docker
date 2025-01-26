package com.example.service;

import com.example.model.ProductRedis;
import com.example.repository.ProductPostgreRepository;
import com.example.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ProductDTO;
import com.example.model.ProductPostgre;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRedisRepository productRedisRepository;

    @Autowired
    private ProductPostgreRepository productPostgreRepository;

    public void saveProduct(ProductPostgre product) {
        productPostgreRepository.save(product);
    }

    public List<ProductPostgre> getAllProducts() {
        return productPostgreRepository.findAll();
    }

    public ProductDTO getProductById(int id) {
        Optional<ProductRedis> productRedis = productRedisRepository.findById(String.valueOf(id));
        
        if (productRedis.isPresent()) {
            return ProductDTO.fromRedis(productRedis.get());
        }
        
        ProductPostgre productPostgre = productPostgreRepository.findById(id).orElse(null);
        
        if (productPostgre != null) {
            ProductRedis productToCache = new ProductRedis();
            productToCache.setId(productPostgre.getId());
            productToCache.setName(productPostgre.getName());
            productRedisRepository.save(productToCache);
            
            return ProductDTO.fromPostgre(productPostgre); 
        }

        return null;
    }
}