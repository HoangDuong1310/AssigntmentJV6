package com.example.finalproject.dao;

import com.example.finalproject.entitys.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {
   @Query("SELECT p FROM ProductEntity p WHERE p.category.id = ?1")
    List<ProductEntity> findByCategoryId(String cid);
}
