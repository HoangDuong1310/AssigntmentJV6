package com.example.finalproject.serviceImpl;

import com.example.finalproject.dao.ProductDAO;
import com.example.finalproject.entitys.ProductEntity;
import com.example.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO dao;

    @Override
    public List<ProductEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public ProductEntity findById(String id) {
        return dao.findById(Integer.valueOf(id)).get();
    }


    @Override
    public List<ProductEntity> findByCategoryId(String cid) {
        return dao.findByCategoryId(cid);
    }

    @Override
    public ProductEntity crate(ProductEntity product) {
        return dao.save(product);
    }

    @Override
    public ProductEntity upddate(ProductEntity product) {
        return dao.save(product);
    }

    @Override
    public void delete(Integer id) {
         dao.deleteById(id);
    }


}
