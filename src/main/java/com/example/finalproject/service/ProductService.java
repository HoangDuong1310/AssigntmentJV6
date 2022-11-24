package com.example.finalproject.service;

import com.example.finalproject.entitys.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(String id);

    List<ProductEntity> findByCategoryId(String cid);
}
