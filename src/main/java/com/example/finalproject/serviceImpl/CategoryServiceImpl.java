package com.example.finalproject.serviceImpl;

import com.example.finalproject.dao.CategoryDAO;
import com.example.finalproject.entitys.CategoryEntity;
import com.example.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryDAO.findAll();
    }
}
