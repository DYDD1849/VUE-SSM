package com.back_ssm.service;

import com.back_ssm.pojo.SnoCourse;
import com.back_ssm.pojo.combination.CnameSno;
import com.back_ssm.pojo.combination.CnoSname;
import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentScoreInCourse;

import java.util.List;

public interface StudentService {
    public Student findStudentBySno(String sno);
    public int addStudent(Student student);
    public Student findStudentByAccount(String Account);
    public List<StudentScoreInCourse> findStudentScoreByCno(String cno);
    public List<StudentScoreInCourse> searchStudentScoreByCnoSname(CnoSname cnoSname);
    public int altStudent(Student student);
    public List<Student> findAllStudent();
    public List<Student> searchStudentByName(String name);
    public List<SnoCourse> searchStudentScoreBySnoCname(CnameSno cnameSno);
}
