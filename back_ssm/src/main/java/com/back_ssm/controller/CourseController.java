package com.back_ssm.controller;

import com.back_ssm.pojo.*;
import com.back_ssm.service.CourseService;
import com.back_ssm.service.StudentService;
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

    @PostMapping(value = "/findStudentCourse")
    @ResponseBody
    public List<SnoCourse> getStudentCourseScore(@RequestBody Student student){
        return courseService.findSnoCourseBySno(student.getSno());
    }
    @PostMapping(value = "/findTeacherCourse")
    @ResponseBody
    public List<Course> getTeacherCourse(@RequestBody Teacher teacher){
        return courseService.findCourseByTno(teacher.getTno());
    }

    @PostMapping(value = "/findAllCourse")
    @ResponseBody
    public List<Course> getAllCourse(){
        return courseService.findAllCourse();
    }

}
