package com.back_ssm.service.impl;

import com.back_ssm.mapper.StudentMapper;
import com.back_ssm.pojo.Student;
import com.back_ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student findStudentByAccount(String account) {
        return studentMapper.findStudentByAccount(account);
    }
    @Override
    public int addStudend(Student student) {
        return studentMapper.addStudent(student);
    }
}
