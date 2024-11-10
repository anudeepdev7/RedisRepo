package com.example.demoredis.controller;

import com.example.demoredis.entity.Product;
import com.example.demoredis.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productRepo.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productRepo.deleteById(id);
    }
}
