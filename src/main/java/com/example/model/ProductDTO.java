package com.example.model;

public class ProductDTO {
    private int id;
    private String name;

    public ProductDTO() {}

    public ProductDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ProductDTO fromRedis(ProductRedis productRedis) {
        return new ProductDTO(productRedis.getId(), productRedis.getName());
    }

    public static ProductDTO fromPostgre(ProductPostgre productPostgre) {
        return new ProductDTO(productPostgre.getId(), productPostgre.getName());
    }
}