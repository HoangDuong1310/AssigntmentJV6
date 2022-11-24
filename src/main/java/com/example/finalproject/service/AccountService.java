package com.example.finalproject.service;

import com.example.finalproject.entitys.AccountEntity;

public interface AccountService {
    AccountEntity findById(String username);

}
