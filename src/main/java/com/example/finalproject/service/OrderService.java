package com.example.finalproject.service;

import com.example.finalproject.entitys.OrderEntity;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {
    OrderEntity create(JsonNode orderData);

    OrderEntity findById(Long id);
}
