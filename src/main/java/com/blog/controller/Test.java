package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Test {
    @ResponseBody
    @GetMapping("/test.do")
    public String get(String test){
        System.out.println(test);
        return test;
    }
    @ResponseBody
    @PostMapping("/test1.do")
    public String post(String test){
        System.out.println(test);
        return test;
    }

}
