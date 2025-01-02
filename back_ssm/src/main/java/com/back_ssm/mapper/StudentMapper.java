package com.back_ssm.mapper;

import com.back_ssm.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("select * from student where account=#{account}")
    public Student findStudentByAccount(String account);
    @Insert("INSERT INTO student VALUES (#{sno}, #{name}, #{account}, #{sex}, #{college}, #{major}, #{phone}, #{address})")
    public int addStudent(Student student);
}
