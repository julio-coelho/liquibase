package com.example.liquibaseh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.liquibaseh2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
