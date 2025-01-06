package com.back_ssm.service;

import com.back_ssm.pojo.CnoSname;
import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentScoreInCourse;

import java.util.List;

public interface StudentService {
    public Student findStudentBySno(String sno);
    public int addStudent(Student student);
    public Student findStudentByAccount(String Account);
    public List<StudentScoreInCourse> findStudentScoreByCno(String cno);
    public List<StudentScoreInCourse> searchStudentScoreBySnoCname(Student student);
    public List<StudentScoreInCourse> searchStudentScoreByCnoSname(CnoSname cnoSname);
    public int altStudent(Student student);
    public List<Student> findAllStudent();
    public List<Student> searchStudentByName(String name);
}
