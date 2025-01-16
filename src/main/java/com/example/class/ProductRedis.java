package com.example.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("ProductRedis") 
public class ProductRedis {
    private String id;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}