package com.example.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecutityController {
    @GetMapping("/login/from")
    public String login(Model model) {
        model.addAttribute("message", "Vui Lonng dang nhap");
        return "/security/login";
    }

        @GetMapping("/login/sussess")
        public String loginSussess(Model model) {
        model.addAttribute("message", "Dang nhap thanh cong");
        return "redirect:/home";

    }
    @GetMapping("/logoff/sussess")
    public String logoffSussess(Model model) {
        model.addAttribute("message", "Dang nhap thanh cong");
        return "redirect:/home";

    }
    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "Sai thong tin dang nhap");
        return "/security/login";

    }

    @GetMapping("/unauthoried")
    public String unauthoried(Model model) {
        model.addAttribute("message", " Khong co quyen truy xuat");
        return "/security/login";

    }
}
