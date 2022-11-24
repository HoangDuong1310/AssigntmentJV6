package com.example.finalproject.service;

import com.example.finalproject.entitys.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();
}
