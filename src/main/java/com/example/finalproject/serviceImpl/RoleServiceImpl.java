package com.example.finalproject.serviceImpl;

import com.example.finalproject.dao.RoleDAO;
import com.example.finalproject.entitys.Role;
import com.example.finalproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
@Autowired
    RoleDAO roleDAO;
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public Role addRole(Role r) {
        return roleDAO.save(r);
    }
}
