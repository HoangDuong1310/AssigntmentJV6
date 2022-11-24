package com.example.finalproject.dao;

import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.entitys.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
}
