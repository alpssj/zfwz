package com.example.demo.controller;

import com.example.demo.domain.Policy;
import com.example.demo.domain.message;
import com.example.demo.domain.person;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.messageRepository;
import com.example.demo.repository.personRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@RequestMapping("log")
public class loginController implements WebMvcConfigurer {//登陆控制器

    @Autowired
    private PolicyRepository Pr;
    @Autowired
    private personRepository pe;
    @Autowired
    private messageRepository ms;

    static List<person> us;
    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/login")
    public String login( Model model, String account, String password) {


        if (pe.validperson(account,password)!=null) {
            us=pe.findByAccount(account);
            model.addAttribute("us",us);
            return "index";
        }
        else{

            return "login";
        }
    }
    @RequestMapping("/stu")
    public String su(Model model,String Pname,String Paccount, String p1){
      pe.addthem( Pname,Paccount,p1,2);
         us=pe.findByAccount(Paccount);
        model.addAttribute("us",us);
      return "index";
    }
    @GetMapping("/change")
    public String change(Model model,String password){
    pe.updateit(password,us.get(0).getP_name());

        model.addAttribute("us",us);
    return "index";
    }
    @GetMapping("/change_password")
    public String ss(String name, Model model) {
        System.out.println(name);
        model.addAttribute("us",us);
        if(us.get(0).getType()==1)
            return "grzx";
            else
        return "change_password";
    }
    @GetMapping("/calendar")
    public String s1( Model model) {
        model.addAttribute("us",us);
        return "calendar";
    }
    @GetMapping("/chartjs")
    public String s2( Model model) {
        model.addAttribute("us",us);
        return "chartjs";
    }
    @GetMapping("/contacts")
    public String s3( Model model) {
        model.addAttribute("us",us);
        return "contacts";
    }
    @GetMapping("/fixed_footer")
    public String s4( Model model) {
        List<message> li=ms.findAll();
        model.addAttribute("li",li);
        model.addAttribute("us",us);
        return "fixed_footer";
    }
    @GetMapping("/fixed_sidebar")
    public String s5( Model model) {
        model.addAttribute("us",us);
        return "fixed_sidebar";
    }
    @GetMapping("/form")
    public String s6( Model model) {
        model.addAttribute("us",us);
        return "form";
    }

    @RequestMapping("/general_elements")
    public String s7(Model model) {
        List<Policy> p = Pr.findAll();
        model.addAttribute("Policy_list",Pr.findAll());
        model.addAttribute("us",us);
        return "general_elements";
    }
    @GetMapping("/index2")
    public String s8( Model model) {
        model.addAttribute("us",us);
        return "index2";
    }
    @GetMapping("/wenjuan")
    public String s9( Model model) {
        model.addAttribute("us",us);
        return "wenjuan";
    }
    @GetMapping("/index")
    public String s10( Model model) {

        model.addAttribute("us",us);
        return "index";
    }
    @GetMapping("/grzx")
    public String s11( Model model) {
        model.addAttribute("us",us);
        return "grzx";
    }
    @GetMapping("/out")
    public String s12( Model model) {
       us.clear();
        model.addAttribute("us",us);
        return "login";
    }
    @GetMapping("/video")
    public String s13( Model model) {
        model.addAttribute("us",us);
        return "video";
    }
    @GetMapping("/news")
    public String s14( Model model) {
        List<Policy> p = Pr.findAll();
        model.addAttribute("Policy_list",Pr.findAll());
        model.addAttribute("us",us);
        return "news";
    }
    @GetMapping("/change_general")
    public String s15( Model model) {
        List<Policy> p = Pr.findAll();
        model.addAttribute("Policy_list",Pr.findAll());
        model.addAttribute("us",us);
        return "change_general";
    }
    @GetMapping("/change_video")
    public String s16( Model model) {
        model.addAttribute("us",us);
        return "change_video";
    }
    @GetMapping("/createquestion")
    public String s17( Model model) {
        model.addAttribute("us",us);
        return "createquestion";
    }
    @GetMapping("/change_news")
    public String s18( Model model) {
        List<Policy> p = Pr.findAll();
        model.addAttribute("Policy_list",Pr.findAll());
        model.addAttribute("us",us);
        return "change_news";
    }
    @GetMapping("/change_message")
    public String s19( Model model) {
        List<message> li=ms.findAll();
        model.addAttribute("li",li);
        model.addAttribute("us",us);
        return "change_message";
    }
}
