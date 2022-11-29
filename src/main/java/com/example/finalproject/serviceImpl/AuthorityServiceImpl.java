package com.example.finalproject.serviceImpl;

import com.example.finalproject.dao.AccountDAO;
import com.example.finalproject.dao.AuthorityDAO;
import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.entitys.Authority;
import com.example.finalproject.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {
@Autowired
    AuthorityDAO authorityDAO;
@Autowired
    AccountDAO accountDAO;
    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<AccountEntity> accounts = accountDAO.getAdministrators();
        return authorityDAO.authoritiesOf(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return authorityDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
authorityDAO.deleteById(id);
    }

    @Override
    public Authority create(Authority auth) {
        return authorityDAO.save(auth);
    }
}
