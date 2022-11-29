package com.example.finalproject.service;

import com.example.finalproject.entitys.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> findAuthoritiesOfAdministrators();

    List<Authority> findAll();

    public void delete(Integer id);

    Authority create(Authority auth);

}
