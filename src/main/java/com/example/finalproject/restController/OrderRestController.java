package com.example.finalproject.restController;

import com.example.finalproject.entitys.OrderEntity;
import com.example.finalproject.entitys.ProductEntity;
import com.example.finalproject.service.OrderService;
import com.example.finalproject.service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public OrderEntity create(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
}
