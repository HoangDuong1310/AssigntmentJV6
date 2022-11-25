package com.example.finalproject.service;

import com.example.finalproject.entitys.OrderEntity;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {
    OrderEntity create(JsonNode orderData);

    OrderEntity findById(Long id);

    List<OrderEntity> findByUsername(String username);
}
