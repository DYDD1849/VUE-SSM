package com.back_ssm.service.impl;

import com.back_ssm.mapper.StudentMapper;
import com.back_ssm.pojo.SnoCourse;
import com.back_ssm.pojo.combination.CnameSno;
import com.back_ssm.pojo.combination.CnoSname;
import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentScoreInCourse;
import com.back_ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student findStudentBySno(String sno) {
        return studentMapper.findStudentBySno(sno);
    }
    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Student findStudentByAccount(String account) {
        return studentMapper.findStudentByAccount(account);
    }

    @Override
    public List<StudentScoreInCourse> findStudentScoreByCno(String cno) {
        return studentMapper.findStudentScoreByCno(cno);
    }

    @Override
    public List<SnoCourse> searchStudentScoreBySnoCname(CnameSno cnameSno) {
        return studentMapper.searchCourseScoreByCnameSno(cnameSno);
    }

    @Override
    public List<StudentScoreInCourse> searchStudentScoreByCnoSname(CnoSname cnoSname) {
        return studentMapper.searchStudentScoreByCnoSname(cnoSname);
    }

    @Override
    public int altStudent(Student student) {
        return studentMapper.altStudent(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        return studentMapper.searchStudentByName(name);
    }
}
