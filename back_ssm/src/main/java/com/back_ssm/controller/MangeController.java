package com.back_ssm.controller;

import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.Teacher;
import com.back_ssm.service.StudentService;
import com.back_ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class MangeController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @PostMapping(value = "/UpdateStudentInfo")
    @ResponseBody
    public int UpdateStudentInfo(@RequestBody Student student){
        if(studentService.findStudentBySno(student.getSno())!=null)
            return studentService.altStudent(student);
        return 0;
    }
    @PostMapping(value = "/UpdateTeacherInfo")
    @ResponseBody
    public int UpdateTeacherInfo(@RequestBody Teacher teacher){
        if(teacherService.findTeacherByTno(teacher.getTno())!=null)
            return teacherService.altTeacher(teacher);
        return 0;
    }
    @GetMapping(value = "/findAllStudent")
    @ResponseBody
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }
    @GetMapping(value = "/findAllTeacher")
    @ResponseBody
    public List<Teacher> findAllTeacher(){
        return teacherService.findAllTeacher();
    }
    @PostMapping(value = "/searchStudent")
    @ResponseBody
    public List<Student> searchStudentByName(@RequestBody Student student){
        return studentService.searchStudentByName(student.getName());
    }

    @PostMapping(value = "/searchTeacher")
    @ResponseBody
    public List<Teacher> searchTeacherByName(@RequestBody Student student){
        return teacherService.searchTeacherByName(student.getName());
    }
}
