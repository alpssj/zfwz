package com.example.demo;



import com.example.demo.domain.Information;
import com.example.demo.domain.Policy;
import com.example.demo.domain.Video;


import com.example.demo.repository.InformationRepository;

import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.VideoRepository;
import com.example.demo.repository.VideoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.SchemaOutputResolver;
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
    private VideoRepository vr;

    @Autowired
    private PolicyRepository Pr;

    @Autowired
    private InformationRepository Ir;

    @Test
    public void contextLoads() {



        List<Information> i = Ir.findAll();
        for(Information in:i){
            System.out.println(in.getUser_name());
        }

        System.out.println();





        System.out.println("new new new new new new new ");
        List<Policy> p = Pr.validPolicy("市政府办公厅");

        for(Policy py:p){
            System.out.println(py.getDepartment());
        }

        System.out.println("new new new new new new new ");



    }

}
