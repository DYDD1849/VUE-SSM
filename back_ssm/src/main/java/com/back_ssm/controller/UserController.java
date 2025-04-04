package com.back_ssm.controller;

import com.back_ssm.pojo.*;
import com.back_ssm.service.StudentService;
import com.back_ssm.service.TeacherService;
import com.back_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
//    学生登录
    @PostMapping(value = "/studentLogin")
    @ResponseBody
    public Student studentLogin(@RequestBody User user){
        System.out.println("登录...");
        User finduser=userService.findUserByAccountPassword(user);
        Student student=null;
        if (finduser!=null) student= studentService.findStudentByAccount(finduser.getAccount());
        return student;
    }
//    教师登录
    @PostMapping(value = "/teacherLogin")
    @ResponseBody
    public Teacher teacherLogin(@RequestBody User user){
        System.out.println("登录...");
        User finduser=userService.findUserByAccountPassword(user);
        Teacher teacher=null;
        if (finduser!=null) teacher= teacherService.findTeacherByAccount(user.getAccount());
        return teacher;
    }

    @PostMapping(value = "/MangerLogin")
    @ResponseBody
    public User MangerLogin(@RequestBody User user){
        System.out.println("登录...");
        User user1 =userService.findUserByAccountPassword(user);
        return user1;
    }

//    学生注册
    @PostMapping(value = "/studentRegister")
    @ResponseBody
    public String StudentRegister(@RequestBody StudentUser studentUser){
        System.out.println("注册...");
        User finduser=userService.findByAccount(studentUser.getUser());
        Student student=studentService.findStudentBySno(studentUser.getStudent().getSno());
        if(finduser==null && student==null){
            int rs1=userService.addUser(studentUser.getUser());
            int rs2=studentService.addStudent(studentUser.getStudent());
            return "1";
        }
        else return "0";
    }
//教师注册
    @PostMapping(value = "/teacherRegister")
    @ResponseBody
    public String TeacherRegister(@RequestBody TeacherUser teacherUser){
        System.out.println("注册...");
//        查询用户和教师有没有冲突
        User finduser=userService.findByAccount(teacherUser.getUser());
        Teacher teacher=teacherService.findTeacherByTno(teacherUser.getTeacher().getTno());
        if(finduser==null && teacher==null){
            int rs1=userService.addUser(teacherUser.getUser());
            int rs2=teacherService.addTeacher(teacherUser.getTeacher());
            return "1";
        }
        else return "0";
    }
}
