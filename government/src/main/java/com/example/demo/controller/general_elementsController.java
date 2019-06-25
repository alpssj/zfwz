package com.example.demo.controller;


import com.example.demo.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
@RequestMapping("gen")
public class general_elementsController implements WebMvcConfigurer {

    @Autowired()
    PolicyRepository Pr;

    @GetMapping("/webs")
    public String indx()
    {
        return "input_Policy";
    }
    @RequestMapping("/deleteGen")
    @ResponseBody
    public boolean deleteGen(String GenName){
        System.err.println(GenName);
     int informateIsOk= Pr.deletePolicy(GenName);
        if(informateIsOk>0){
            return true;
        }else{
            return false;
        }
    }
}
