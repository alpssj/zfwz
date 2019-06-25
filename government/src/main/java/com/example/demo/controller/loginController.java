package com.example.demo.controller;

import com.example.demo.domain.Policy;
import com.example.demo.domain.Video;
import com.example.demo.domain.person;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.personRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @作用 ：登陆控制器
 * @CreateTime: 2019-06-11-10:40
 * @Author :杨阳
 * @ClassName :HomeController
 **/
@Controller
@RequestMapping("log")
public class loginController implements WebMvcConfigurer {//登陆控制器

    @Autowired
    private PolicyRepository Pr;
    @Autowired
    private personRepository pe;




@GetMapping("/")
public String login1( ) {
    return "login";
}
    @GetMapping("/login")
    public String login( Model model, String account, String password) {
        person p=pe.validperson(account, password);
        List<person> us=pe.findByName(account);
        if (pe.validperson(account,password)!=null) {
            model.addAttribute("us",us);
            return "fixed_footer";
        }
        else{

            return "login";
        }
    }
//    @PostMapping("/stu")
//    public String su(Model model,String Pname,String Paccount, String p1){
//      pe.addthem( Pname,Paccount,p1,2);
//        List<person> us=pe.findByName(Paccount);
//        model.addAttribute("us",us);
//
//      return "index";
//
//    }
    @GetMapping("/change")
    public String change(String password){
//    pe.updateit(password,us.get(0).getP_name());
    return "index";
    }
    @GetMapping("/change_password")
    public String ss(@PathVariable("P_name") String P_name ) {

    System.out.print(P_name);
        return "change_password";
    }


    @RequestMapping("/general_elements")
    public String general_elements(Model model) {
        List<Policy> p = Pr.findAll();
        for(Policy py:p){
            System.out.println(py.getDepartment());
            System.out.println(py.getPolicy_id());
            System.out.println(py.getPolicy_link());
            System.out.println(py.getPolicy_name());
        }
        model.addAttribute("Policy_list",Pr.findAll());
        return "general_elements";
    }
    @PostMapping("/stu")
    public String su(Model model,String Pname,String Paccount, String p1){
        pe.addthem( Pname,Paccount,p1,2);
        List<person> us=pe.findByName(Paccount);
        model.addAttribute("us",us);

        return "fixed_footer";

    }

}
