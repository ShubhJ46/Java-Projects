package com.example.UserSecurity.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private String description;

    public Product() {}
    public Product(Integer id, String name, Integer price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getPrice() { return price; }
    public String getDescription() { return description; }

    public void setName (String name) { this.name = name; }
    public void setPrice (Integer price) { this.price = price; }
    public void setDescription (String description) { this.description = description; }


}