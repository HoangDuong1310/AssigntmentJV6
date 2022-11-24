package com.example.finalproject.dao;

import com.example.finalproject.entitys.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer> {
}
