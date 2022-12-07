package com.example.finalproject.controller;

import com.example.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SecutityController {
    @Autowired
    UserService userService;
    @RequestMapping("/security/login/from")
    public String login(Model model) {
        model.addAttribute("message", "Vui Lonng dang nhap");
        return "/security/login";
    }

    @RequestMapping("/security/login/success")
        public String loginSussess(Model model) {
        model.addAttribute("message", "Dang nhap thanh cong");
        return "redirect:/home";

    }
    @RequestMapping("/security/logoff/success")
    public String logoffSussess(Model model) {
        model.addAttribute("message", "Dang nhap thanh cong");
        return "redirect:/home";

    }
    @RequestMapping("/security/login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "Sai thong tin dang nhap");
        return "/security/login";

    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model) {
        model.addAttribute("message", " Khong co quyen truy xuat");
        return "/security/login";

    }
    @RequestMapping("/oauth2/login/success")
    public String success(OAuth2AuthenticationToken oauth2){
        userService.loginFrom(oauth2);
        return "forward:/security/login/success";
    }
}
