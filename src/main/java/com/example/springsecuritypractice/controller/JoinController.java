package com.example.springsecuritypractice.controller;

import com.example.springsecuritypractice.dto.JoinDTO;
import com.example.springsecuritypractice.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String joinPage(){

        return "join";
    }

    @PostMapping("/joinProcess")
    public String joinProcess(JoinDTO joinDTO){

        System.out.println(joinDTO.getUsername());

        joinService.joinProcess(joinDTO);

        return "redirect:/login";
    }
}
