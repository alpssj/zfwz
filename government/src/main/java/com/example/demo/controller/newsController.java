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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @作用 ：新闻控制层
 * @CreateTime: 2019-06-20-08:26
 * @Author :杨阳
 * @ClassName :newsController
 **/
@Controller
@RequestMapping("/new")
public class newsController implements WebMvcConfigurer {//新闻控制层
    @Autowired()
    PolicyRepository Pr;

    @RequestMapping("/news")
    public String general_elements(Model model) {
        List<Policy> p = Pr.findAll();
        model.addAttribute("Policy_list",Pr.findAll());
        return "news";
    }
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

    @RequestMapping("/saveGen")
    public String saveGen(HttpServletRequest request, String fileName, String fileLink, String fileDepartment){
        int isoks = Pr.savePolicy(fileName,fileLink,fileDepartment);

        request.setAttribute("isok",isoks);
        return "input_Policy";
    }

}
