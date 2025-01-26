package com.example.repository;

import com.example.model.ProductPostgre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPostgreRepository extends JpaRepository<ProductPostgre, Integer> {
}