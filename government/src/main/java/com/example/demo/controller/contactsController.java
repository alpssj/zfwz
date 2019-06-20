package com.example.demo.controller;

import com.example.demo.domain.Information;
import com.example.demo.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@RequestMapping("con")
public class contactsController implements WebMvcConfigurer {
    @Autowired
    InformationRepository ir;
    @RequestMapping("/contacts")
    public String contacts() {
        return "contacts";
    }
    @RequestMapping("/contactsData")
    @ResponseBody
    public List<Information> contactsData() {
        return ir.findAll();
    }
}
