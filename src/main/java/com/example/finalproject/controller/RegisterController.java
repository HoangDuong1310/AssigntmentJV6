package com.example.finalproject.controller;

import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("account", new AccountEntity());
        return "security/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("account") AccountEntity account, Model model) {
        System.out.println(account);
        account.setPhoto("user.png");
        accountService.save(account);
        return "security/login";
    }
}
