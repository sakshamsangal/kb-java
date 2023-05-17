package com.example.demo.rest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


// view is not supported
// gives data only

/*
# database connection
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root

spring.main.banner-mode=off
logging.level.root=ERROR
server.port=8080

 */
@RestController // controller + response body
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
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }


}
