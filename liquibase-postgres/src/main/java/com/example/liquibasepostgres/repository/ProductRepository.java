package com.example.liquibasepostgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.liquibasepostgres.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
