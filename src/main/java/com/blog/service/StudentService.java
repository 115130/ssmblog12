//package com.blog.service;
//
//
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import test.SSM.bean.Student;
//import test.SSM.mapper.StudentDao;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Component(value = "studentService")
//@Transactional
//public class StudentService {
//    @Resource
//    StudentDao studentDao;
//
//    public List<Student> getAllStudent(){
//        return studentDao.selectStudentAll();
//    }
//    public void insertStudent(Student student){
//       studentDao.insertStudent(student);
//    }
//
//}
