package com.example.finalproject.serviceImpl;


import com.example.finalproject.dao.OrderDAO;
import com.example.finalproject.dao.OrderDetailDAO;
import com.example.finalproject.entitys.OrderDetailEntity;
import com.example.finalproject.entitys.OrderEntity;
import com.example.finalproject.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public OrderEntity create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        OrderEntity order = mapper.convertValue(orderData, OrderEntity.class);
        orderDAO.save(order);

        TypeReference<List<OrderDetailEntity>> type = new TypeReference<List<OrderDetailEntity>>() {};
        List<OrderDetailEntity> details = mapper.convertValue(orderData.get("orderDetails") , type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        orderDetailDAO.saveAll(details);

        return order;

    }

    @Override
    public OrderEntity findById(Long id) {
        return orderDAO.findById(id).get();
    }
}
