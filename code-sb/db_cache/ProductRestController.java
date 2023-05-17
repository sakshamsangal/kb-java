package com.example.demo.db_cache;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductRestController{

    private final ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    @GetMapping("/products/{id}")
    @Transactional(readOnly = true)
    @Cacheable("product-cache")
    public Product getProductById(@PathVariable("id") int id) {
        return productRepository.findById(id).orElse(null);
    }


    @PostMapping("/products")
    public Product postProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products")
    public Product putProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    @CacheEvict("product-cache")
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }


}
