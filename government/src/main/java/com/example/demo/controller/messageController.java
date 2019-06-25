package com.example.demo.controller;

import com.example.demo.repository.messageRepository;
import org.omg.CORBA.portable.IDLEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static sun.security.krb5.Confounder.intValue;

@Controller
@RequestMapping("/mes")
public class messageController {

    @Autowired
    private messageRepository ms;

    @RequestMapping("/deit")
    @ResponseBody
    public boolean deleteGen(String IDe){
        System.err.println(IDe);
        int ID= Integer.parseInt(IDe);
        int IsOk= ms.deleteit(ID);
        if(IsOk>0){
            return true;
        }else{
            return false;
        }

    }
}
