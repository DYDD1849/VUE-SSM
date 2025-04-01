package com.back_ssm.controller;

import com.back_ssm.pojo.*;
import com.back_ssm.pojo.combination.CnameSno;
import com.back_ssm.pojo.combination.CnoSname;
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

//    输入学号和课程名，输出学生信息和学生成绩。
    @PostMapping(value = "/searchStudentScore")
    @ResponseBody
    public List<SnoCourse> getStudentScoreBySnoCname(@RequestBody CnameSno cnameSno){
        return studentService.searchStudentScoreBySnoCname(cnameSno);
    }

    //    输入课程号和学生名，输出学生信息和学生成绩
    @PostMapping(value = "/searchStudentScoreByCnoSname")
    @ResponseBody
    public List<StudentScoreInCourse> getStudentScoreByCnoSname(@RequestBody CnoSname cnoSname){
        return studentService.searchStudentScoreByCnoSname(cnoSname);
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
