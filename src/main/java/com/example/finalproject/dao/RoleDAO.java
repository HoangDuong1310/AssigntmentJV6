package com.example.finalproject.dao;

import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.entitys.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer> {
}
