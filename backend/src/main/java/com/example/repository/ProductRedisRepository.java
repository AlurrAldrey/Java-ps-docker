package com.example.repository;

import com.example.model.ProductRedis;
import org.springframework.data.repository.CrudRepository;

public interface ProductRedisRepository extends CrudRepository<ProductRedis, String> {
}