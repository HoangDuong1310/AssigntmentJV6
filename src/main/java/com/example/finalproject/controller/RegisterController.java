package com.example.finalproject.controller;

import com.example.finalproject.bean.AccountBean;
import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.entitys.Authority;
import com.example.finalproject.entitys.Role;
import com.example.finalproject.service.AccountService;
import com.example.finalproject.service.AuthorityService;
import com.example.finalproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;
    @Autowired
    HttpServletRequest req;

    @Autowired
    RoleService roleService;
    @Autowired
    AuthorityService authorityService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("account", new AccountBean());
        return "security/register";
    }

    @PostMapping("/register")
    public String registerPost(@Validated @ModelAttribute("account") AccountBean account, Errors errors, Model model) {

        if (errors.hasErrors()) {
            System.out.println("loi");
            model.addAttribute("massage", "Khong duoc de trong");
            return "security/register";
        }
        System.out.println("loi1");

//        List<AccountEntity> list = accountService.findAll();
//        for (AccountEntity a : list) {
//            if (a.getUsername().equals(account.getUsername())) {
//                req.setAttribute("error", "Tai Khoan Da Ton Tai");
//                return "security/register";
//            }
//        }


        AccountEntity acc = new AccountEntity();
        acc.setUsername(account.getUsername());
        acc.setFullname(account.getFullname());
        acc.setPassword(account.getPassword());
        acc.setEmail(account.getEmail());
        acc.setPhoto("user.png");
        accountService.save(acc);
        Role r = new Role();
        r.setId("CUST");
        r.setName("Customers");
        roleService.addRole(r);
        Authority auth = new Authority();
        auth.setAccount(acc);
        auth.setRole(r);
        authorityService.create(auth);
        req.setAttribute("error", "Dang ky thanh cong");
        return "redirect:/security/login/from";
    }
}
