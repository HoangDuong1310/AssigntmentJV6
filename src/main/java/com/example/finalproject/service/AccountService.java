package com.example.finalproject.service;

import com.example.finalproject.entitys.AccountEntity;

import java.util.List;

public interface AccountService {
    AccountEntity findById(String username);
    List<AccountEntity> findAll();
    List<AccountEntity> getAministrators();
    AccountEntity save(AccountEntity account);
}
