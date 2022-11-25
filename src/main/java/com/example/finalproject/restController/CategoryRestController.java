package com.example.finalproject.restController;

import com.example.finalproject.entitys.CategoryEntity;
import com.example.finalproject.entitys.ProductEntity;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;


    @GetMapping()
    public List<CategoryEntity> getAll() {
        return categoryService.findAll();
    }
}
