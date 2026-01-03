package com.example.UserSecurity.Service;

import com.example.UserSecurity.Exception.ProductNotFoundException;
import com.example.UserSecurity.Model.Product;
import com.example.UserSecurity.Repository.ProductRepository;
import com.example.UserSecurity.View.ProductSummary;
import com.example.UserSecurity.dto.ProductRequest;
import com.example.UserSecurity.dto.ProductResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }


    public List<Product> getProducts() { return repo.findAll(); }
    public Product addProduct(ProductRequest req) {
        Product p = new Product();
        p.setName(req.getName());
        p.setPrice(req.getPrice());
        p.setDescription(req.getDescription());
        return repo.save(p);
    }
    public Product getProductById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product updateProduct(Integer id, ProductRequest req) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        existing.setName(req.getName());
        existing.setPrice(req.getPrice());
        existing.setDescription(req.getDescription());

        return repo.save(existing);
    }

    public void deleteProduct(Integer id) {
        if (!repo.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        repo.deleteById(id);
    }

    public List<Product> getProductsCheaperThan(Integer price) {
        return repo.findByPriceLessThan(price);
    }

    public Page<Product> getProductsPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public ProductResponse toResponse(Product p) {
        ProductResponse res = new ProductResponse();
        res.setId(p.getId());
        res.setName(p.getName());
        res.setPrice(p.getPrice());
        res.setDescription(p.getDescription());
        return res;
    }

    @Modifying(clearAutomatically = true)
    @Transactional
    public int increasePrice(Integer amount) {
        return repo.increasePrice(amount);
    }

    public List<Product> searchByNameContaining(String keyword) {
        return repo.searchByNameContaining(keyword);
    }

    public List<ProductSummary> getProductSummaries() {
        return repo.getProductSummaries();
    }
}
