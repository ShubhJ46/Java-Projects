package com.example.product3.controller;

import com.example.product3.View.ProductSummary;
import com.example.product3.dto.ProductRequest;
import com.example.product3.dto.ProductResponse;
import com.example.product3.model.Product;
import com.example.product3.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {
    private final ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() { return ResponseEntity.ok(productService.getProducts()); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(productService.toResponse(product));
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductRequest req) {
        Product created = productService.addProduct(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id,
            @Valid @RequestBody ProductRequest req) {

        return ResponseEntity.ok(productService.updateProduct(id, req));
    }

    @GetMapping("/cheaper/{price}")
    public ResponseEntity<List<Product>> getProductsCheaperThan(@PathVariable Integer price) {
        return ResponseEntity.ok(productService.getProductsCheaperThan(price));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getProductsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return ResponseEntity.ok(productService.getProductsPage(pageable));
    }

    @PutMapping("/increase-price")
    public ResponseEntity<String> increasePrice(@RequestParam Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        int updatedCount = productService.increasePrice(amount);
        return ResponseEntity.ok("Updated prices for " + updatedCount + " products.");
    }

    //GET /products/search?name=lap
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByNameContaining(@RequestParam("name") String keyword) {
        return ResponseEntity.ok(productService.searchByNameContaining(keyword));
    }

    @GetMapping("/summary")
    public ResponseEntity<List<ProductSummary>> getProductSummaries() {
        return ResponseEntity.ok(productService.getProductSummaries());
    }
}
