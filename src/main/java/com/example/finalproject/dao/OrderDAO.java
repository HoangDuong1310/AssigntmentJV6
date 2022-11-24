package com.example.finalproject.dao;

import com.example.finalproject.entitys.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
}
