package com.example.finalproject.serviceImpl;

import com.example.finalproject.dao.AccountDAO;
import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO dao;

    @Override
    public List<AccountEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public List<AccountEntity> getAministrators() {
        return dao.getAdministrators();
    }

    @Override
    public AccountEntity findById(String username) {

        return dao.findById(username).get();
    }
}
