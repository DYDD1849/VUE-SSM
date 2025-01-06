package com.back_ssm.mapper;

import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.StudentScoreInCourse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student where sno=#{sno}")
    public Student findStudentBySno(String sno);
    @Select("select * from student where account=#{account}")
    public Student findStudentByAccount(String account);
    @Select("select student.*,sc.sscore from student join sc on sc.sno=student.sno where sc.cno=#{cno}")
    public List<StudentScoreInCourse> findStudentScoreByCno(String cno);
    @Insert("INSERT INTO student VALUES (#{sno}, #{name}, #{account}, #{sex}, #{college}, #{major}, #{phone}, #{address})")
    public int addStudent(Student student);
    @Update("update student set name = #{name},sex = #{sex},college = #{college},major = #{major},phone = #{phone},address = #{address} where sno = #{sno}")
    public int altStudent(Student student);
    @Select("select * from student")
    public List<Student> findAllStudent();
    @Select("select * from student where name like CONCAT('%', #{name}, '%') ")
    public List<Student> searchStudentByName(String name);
}
