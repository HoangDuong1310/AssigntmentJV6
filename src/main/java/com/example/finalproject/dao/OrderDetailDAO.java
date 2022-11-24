package com.example.finalproject.dao;

import com.example.finalproject.entitys.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetailEntity, Integer> {
}
