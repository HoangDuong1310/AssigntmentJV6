package com.example.finalproject.restController;

import com.example.finalproject.entitys.ProductEntity;
import com.example.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping()
    public List<ProductEntity> getAll() {
        return productService.findAll();
    }
    @PostMapping
    public  ProductEntity crate(@RequestBody ProductEntity product){

        return productService.crate(product);
    }
    @PostMapping("{id}")
    public ProductEntity update(@PathVariable("id") Integer id , @RequestBody ProductEntity product) {
        return productService.upddate(product);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id ) {
         productService.delete(id);
    }

}
