package com.example.product3.repositary;

import com.example.product3.View.ProductSummary;
import com.example.product3.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    List<Product> findByPriceLessThan(Integer price);
    Page<Product> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = p.price + :amount")
    int increasePrice(@Param("amount") Integer amount);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List <Product> searchByNameContaining(String keyword);

    @Query("SELECT new com.example.product3.View.ProductSummary(p.name, p.price) FROM Product p")
    List<ProductSummary> getProductSummaries();

}