package com.example.UserSecurity.View;

public class ProductSummary {
    private final String name;
    private final Integer price;

    public ProductSummary(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}