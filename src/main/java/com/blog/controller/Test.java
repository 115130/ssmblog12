//package com.blog.controller;
//
//import com.sun.deploy.net.HttpResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import test.SSM.bean.Student;
//import test.SSM.service.StudentService;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class Test {
//    @Resource
//    StudentService studentService;
//
//    @GetMapping("/index.do")
//    public String get(Model model){
//        model.addAttribute("test","test");
//        return "templates/temple";
//    }
//
//
//    @GetMapping("/testTempleStudent.do")
//    public String getTempleStudent(Model model){
//        List<Student> student = studentService.getAllStudent();
//        model.addAttribute("students",student);
//        return "templates/student.html";
//    }
//
//
//    @RequestMapping("/hello.do")
//    public String temple(Model model){
//        model.addAttribute("name","thymeleaf");
//        return "templates/test.html";
//    }
//
//    @RequestMapping("/1")
//    public String get123(){
//        return "html";
//    }
//
//    @RequestMapping("/")
//    public String get13(){
//        return "html";
//    }
//
//
//    @RequestMapping("/jsp/jsp.do")
//    public String getjsp(){
//        return "i";
//    }
//
//    @PostMapping("/setStudent.do")
//    public String setStudent(Student student){
//        studentService.insertStudent(student);
//        return "html";
//    }
//
//    @ResponseBody
//    @GetMapping("/testStudent.do")
//    public List<Student> getStudent(){
//        return studentService.getAllStudent();
//    }
//}
