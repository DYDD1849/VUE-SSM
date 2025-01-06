package com.back_ssm.service.impl;

import com.back_ssm.mapper.StudentMapper;
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
    public int altStudent(Student student) {
        return studentMapper.altStudent(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }
}
