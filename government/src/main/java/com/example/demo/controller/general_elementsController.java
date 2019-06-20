package com.example.demo.controller;

import com.example.demo.domain.Policy;
import com.example.demo.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@RequestMapping("gen")
public class general_elementsController implements WebMvcConfigurer {

    @Autowired()
    PolicyRepository Pr;
    @RequestMapping("/general_elements")
    public String general_elements(Model model) {
        List<Policy> p = Pr.findAll();
        model.addAttribute("Policy_list",Pr.findAll());
        return "general_elements";
    }
//    @GetMapping("/webs")
//    public String indx()
//    {
//        return "input_Policy";
//    }
//    @RequestMapping("/deleteGen")
//    @ResponseBody
//    public boolean deleteGen(String GenName){
//        System.err.println(GenName);
//     int informateIsOk= Pr.deletePolicy(GenName);
//        if(informateIsOk>0){
//            return true;
//        }else{
//            return false;
//        }
//    }
}
