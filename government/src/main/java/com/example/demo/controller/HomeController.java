//package com.example.demo.controller;
//
//import com.example.demo.domain.*;
//import com.example.demo.domain.Information;
//
//import com.example.demo.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
///**
// * @作用 ：登陆控制器
// * @CreateTime: 2019-06-11-10:40
// * @Author :杨阳
// * @ClassName :HomeController
// **/
//@Controller
//public class HomeController implements WebMvcConfigurer {//登陆控制器
//
//    @Autowired()
//    PolicyRepository Pr;
//    @Autowired
//    personRepository pe;
//    @Autowired
//    UserRepository ur;
//    @Autowired
//    InformationRepository ir;
//    @Autowired
//    IInformate informate;
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("fixed_footer");
//        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/contacts").setViewName("contacts");
//        registry.addViewController("/fixed_footer").setViewName("fixed_footer");
//        registry.addViewController("/input_Policy").setViewName("input_Policy");
//        registry.addViewController("/general_elements").setViewName("general_elements");
//        registry.addViewController("/video").setViewName("video");
//        registry.addViewController("/newsluru").setViewName("newsluru");
//        registry.addViewController("/a").setViewName("a");
//    }
//    String name = null;
//
//
//    @GetMapping("/")
//    public String index() {
//        return "fixed_footer";
//    }
//    @GetMapping("/login")
//    public String login( Model model, String account, String password) {
//        person p=pe.validperson(account, password);
//        List<person> us=pe.findAll();
//        if (pe.validperson(account,password)!=null) {
//            model.addAttribute("us",pe.findAll());
//            return "fixed_footer";
//
//        }
//        else{
//            return "login";
//        }
//    }
//    @GetMapping("/webs")
//    public String indx()
//    {
//        return "input_Policy";
//    }
//    @RequestMapping("/home")
//    public String home(Model model, String account, String password) {
//        User t=ur.validTeacher("user", "123");
//        model.addAttribute("name",t.getUser_name());
//        model.addAttribute("User_list",ur.findAll());
//        return "home";
//    }
//
//    @RequestMapping("/contacts")
//    public String contacts() {
//        return "contacts";
//    }
//
//    @RequestMapping("/contactsData")
//    @ResponseBody
//    public List<Information> contactsData() {
//        return ir.findAll();
//    }
//
//
//    @RequestMapping("/general_elements")
//    public String general_elements(Model model) {
//        List<Policy> p = Pr.findAll();
//        model.addAttribute("Policy_list",Pr.findAll());
//        return "general_elements";
//    }
//    @RequestMapping("/videoDate")
//    public String videoDate(){
//        return "/video";
//    }
//
//
//
//    @RequestMapping("/video")
//    @ResponseBody
//    public List<Informate> video(){
//        List<Informate> informateList=informate.findAll();
//        System.err.println(informateList.size());
//        return informateList;
//    }
//
//    @RequestMapping("/deleteGen")
//    @ResponseBody
//    public boolean deleteGen(String GenName){
//        System.err.println(GenName);
//        int informateIsOk= Pr.deletePolicy(GenName);
//        if(informateIsOk>0){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//
//}
