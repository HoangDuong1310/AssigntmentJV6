package com.example.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String list() {
        return "/home/home";
    }

    @GetMapping({"/admin","/admin/home/index"})
    public String admin() {
        return "redirect:/";
    }


}
