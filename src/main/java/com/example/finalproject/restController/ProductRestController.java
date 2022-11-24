package com.example.finalproject.restController;

import com.example.finalproject.entitys.ProductEntity;
import com.example.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;
    @GetMapping("{id}")
    public ProductEntity getOne(@PathVariable("id") Integer id) {
        return productService.findById(String.valueOf(id));
    }
}
