package com.back_ssm.service;

import com.back_ssm.pojo.Student;

public interface StudentService {
    public Student findStudentByAccount(String account);
    public int addStudend(Student student);
}
