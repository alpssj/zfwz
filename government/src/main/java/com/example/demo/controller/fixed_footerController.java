package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class fixed_footerController {
    @GetMapping("/")
public String foot(){
        return "fixed_footer";
    }

}
