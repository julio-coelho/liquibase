package com.example.liquibaseh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.liquibaseh2.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
