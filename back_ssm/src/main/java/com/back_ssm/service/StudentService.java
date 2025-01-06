package com.back_ssm.service;

import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentScoreInCourse;
import com.back_ssm.pojo.Teacher;

import java.util.List;

public interface StudentService {
    public Student findStudentBySno(String sno);
    public int addStudent(Student student);
    public Student findStudentByAccount(String Account);
    public List<StudentScoreInCourse> findStudentScoreByCno(String cno);
    public int altStudent(Student student);
    public List<Student> findAllStudent();
    public List<Student> searchStudentByName(String name);
}
