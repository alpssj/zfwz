package com.example.demo.controller;


import com.example.demo.domain.Video;
import com.example.demo.repository.VideoRepository;
import com.example.demo.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("vio")
public class videoController implements WebMvcConfigurer {
    @Autowired
    VideoRepository Vi;

    @RequestMapping("/videoDate")
    public String videoDate(){
        return "/video";
    }
    @RequestMapping("/video")
    @ResponseBody
    public List<Video> video(){
       List<Video> videoList=Vi.findAll();
       System.err.println(videoList.size());
       return videoList;
    }

    @GetMapping("/webs")
    public String indx()
    {
        return "input_Video";
    }



    @RequestMapping("/saveVio")
    public String saveVio(HttpServletRequest request, String videoName, String videoLink, String videoKind){
        int inVos = Vi.saveVideo(videoName,videoLink,videoKind);

        request.setAttribute("inVos",inVos);
        return "input_Video";
    }

    @RequestMapping("/deleteVio")
    @ResponseBody
    public boolean deleteGen(String VioName){
        System.err.println(VioName);
        int videoisOk= Vi.deleteVideo(VioName);
        if(videoisOk>0){
            return true;
        }else{
            return false;
        }
    }


}
