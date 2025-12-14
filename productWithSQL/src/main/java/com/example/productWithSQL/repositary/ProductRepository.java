package com.example.productWithSQL.repositary;

import com.example.productWithSQL.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    List<Product> findByPriceLessThan(Integer price);
}