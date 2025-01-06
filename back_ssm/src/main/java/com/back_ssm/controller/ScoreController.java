package com.back_ssm.controller;

import com.back_ssm.pojo.Course;
import com.back_ssm.pojo.Score;
import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentScoreInCourse;
import com.back_ssm.service.ScoreService;
import com.back_ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    StudentService studentService;
    @Autowired
    ScoreService scoreService;
    @PostMapping(value = "/findStudentScore")
    @ResponseBody
    public List<StudentScoreInCourse> getStudentScore(@RequestBody Course course){
        return studentService.findStudentScoreByCno(course.getCno());
    }

    @PostMapping(value = "/searchStudentScore")
    @ResponseBody
    public List<StudentScoreInCourse> getStudentScore(@RequestBody Student student){
        return studentService.searchStudentScore(student);
    }


    @PostMapping(value = "/addScore")
    @ResponseBody
    public int addScore(@RequestBody Score score){

        if(scoreService.findScore(score)==null)return scoreService.addScore(score);
        return 0;
    }
    @PostMapping(value = "/delScore")
    @ResponseBody
    public int delScore(@RequestBody Score score){
        return scoreService.delScore(score);
    }
    @PostMapping(value = "/altScore")
    @ResponseBody
    public int altScore(@RequestBody Score score){
        return scoreService.altScore(score);
    }
}
