package com.example.finalproject.dao;

import com.example.finalproject.entitys.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
   @Query("SELECT o FROM OrderEntity o WHERE o.account.username=?1")
    List<OrderEntity> findByUsername(String username);
}
