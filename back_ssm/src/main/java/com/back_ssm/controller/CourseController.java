package com.back_ssm.controller;

import com.back_ssm.pojo.SnoCourse;
import com.back_ssm.pojo.Student;
import com.back_ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping(value = "/findSnoCourse")
    @ResponseBody
    public List<SnoCourse> getStudentCourseScore(@RequestBody Student student){
        return courseService.findSnoCourseBySno(student.getSno());
    }
}
