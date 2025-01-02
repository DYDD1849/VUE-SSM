package com.back_ssm.service;

import com.back_ssm.pojo.Student;

public interface StudentService {
    public Student findStudentBySno(String sno);
    public int addStudent(Student student);
    public Student findStudentByAccount(String Account);
}
