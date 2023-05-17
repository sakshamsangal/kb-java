package com.example.demo.rest;

import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
