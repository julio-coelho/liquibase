package com.example.liquibasepostgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.liquibasepostgres.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
