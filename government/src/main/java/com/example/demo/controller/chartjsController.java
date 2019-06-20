package com.example.demo.controller;

import com.example.demo.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("req")
public class chartjsController implements WebMvcConfigurer {
    @Autowired
    InformationRepository ir;
    @GetMapping("/chartjs")
    public String chartjs( ) {
        return "chartjs";
    }


}
