package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller

public class indexController implements WebMvcConfigurer {

    @GetMapping("/")
    public String sss( ) {
        return "index";
    }

}
