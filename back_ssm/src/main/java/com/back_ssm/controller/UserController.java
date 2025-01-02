package com.back_ssm.controller;

import com.back_ssm.pojo.User;
import com.back_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody User user){
        System.out.println("查询...");
        User finduser=userService.findUser(user);
        if (finduser!=null)
        return  "1";
        else
            return "0";

    }
    @PostMapping(value = "/register")
    @ResponseBody
    public String register(@RequestBody User user){
        System.out.println("注册...");
        if(userService.findUser(user)==null){
            int rs=userService.addUser(user);
            return ""+rs;
        }
        else return "用户已经存在";
    }
}
