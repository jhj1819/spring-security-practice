package com.example.springsecuritypractice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    @GetMapping("/admin")
    public String adminPage(){

        return "admin";
    }
}
