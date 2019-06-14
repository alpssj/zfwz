package com.example.demo.controller;

import com.example.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @作用 ：登陆控制器
 * @CreateTime: 2019-06-11-10:40
 * @Author :杨阳
 * @ClassName :HomeController
 **/
@Controller
public class HomeController implements WebMvcConfigurer {//登陆控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/contacts").setViewName("contacts");
        registry.addViewController("/fixed_footer").setViewName("fixed_footer");
        registry.addViewController("/page_404").setViewName("page_404");
    }


    String name = null;
    @Autowired
    private UserRepository ur;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, String account, String password) {
        if ("abc".equals(account) && "123".equals(password)) {
            return "/fixed_footer";
        }
        else{
            return "index";
        }

    }

    @RequestMapping("/home")
    public String home(Model model, String account, String password) {
        User t=ur.validTeacher("user", "123");
        model.addAttribute("name",t.getUser_name());
        model.addAttribute("User_list",ur.findAll());
        return "home";
    }


}
