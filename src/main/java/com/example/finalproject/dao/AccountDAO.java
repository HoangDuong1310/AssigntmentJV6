package com.example.finalproject.dao;

import com.example.finalproject.entitys.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<AccountEntity, String> {
}
