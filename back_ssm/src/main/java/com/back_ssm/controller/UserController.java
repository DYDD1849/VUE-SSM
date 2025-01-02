package com.back_ssm.controller;

import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentUser;
import com.back_ssm.pojo.User;
import com.back_ssm.service.StudentService;
import com.back_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/studentLogin")
    @ResponseBody
    public Student studentLogin(@RequestBody User user){
        System.out.println("登录...");
        User finduser=userService.findUser(user);
        Student student=null;
        if (finduser!=null) student= studentService.findStudentByAccount(finduser.getAccount());
        return student;
    }
    @PostMapping(value = "/teacherLogin")
    @ResponseBody
    public Student teacherLogin(@RequestBody User user){
        System.out.println("登录...");
        User finduser=userService.findUser(user);
        Student student=null;
        if (finduser!=null) student= studentService.findStudentByAccount(finduser.getAccount());
        return student;
    }
    @PostMapping(value = "/studentRegister")
    @ResponseBody
    public String Studentregister(@RequestBody StudentUser studentUser){
        System.out.println("注册...");
        User finduser=userService.findUser(studentUser.getUser());
        Student student=studentService.findStudentByAccount(studentUser.getStudent().getAccount());
        if(finduser==null && student==null){
            int rs1=userService.addUser(studentUser.getUser());
            int rs2=studentService.addStudend(studentUser.getStudent());
            return "用户注册"+rs1+";学生注册"+rs2;
        }
        else return "用户或学生已存在";
    }
}
