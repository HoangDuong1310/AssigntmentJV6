package com.example.finalproject.controller;

import com.example.finalproject.entitys.ProductEntity;
import com.example.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String list(Model model , @RequestParam("cid") Optional<String> cid) {
        if (cid.isPresent()){
            List<ProductEntity>  list = productService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        }else{
            List<ProductEntity>  list = productService.findAll();
            model.addAttribute("items", list);
        }

        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        ProductEntity item = productService.findById(id);
        model.addAttribute("item", item);
        return "/product/detail";
    }
}
