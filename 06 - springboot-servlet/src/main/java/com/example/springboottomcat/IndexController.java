package com.example.springboottomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
    
    public static void main(String[]args){
        SpringApplication.run(IndexController.class,args);
    }

}


