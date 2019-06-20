package com.example.demo;

import com.example.demo.domain.Information;
import com.example.demo.domain.Policy;
import com.example.demo.domain.User;


import com.example.demo.repository.InformationRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.transform.Source;
import java.util.List;

/**
 * @作用 ：test
 * @CreateTime: 2019-06-12-17:41
 * @Author :杨阳
 * @ClassName :test
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {//test
    @Autowired
    private UserRepository ur;
    @Autowired
    private InformationRepository Ir;
    @Autowired
    private PolicyRepository Pr;

    @Test
    public void contextLoads() {
        System.out.println("----------------------");
        User t=ur.validTeacher("user", "123");
        System.out.println("t2 "+t.getUser_name());


        Information i = Ir.validInformation("路桥川");
        System.out.println("success   " + i.getJob() );
        List <Information>  l = Ir.findByKind("2");


        for(Information in:l){
            System.out.println(in.getUser_name());
        }


        System.out.println("new new new new new new new ");
        List<Policy> p = Pr.validPolicy("市政府办公厅");

        for(Policy py:p){
            System.out.println(py.getDepartment());
        }

        System.out.println("new new new new new new new ");

    }

}
