package com.back_ssm.mapper;

import com.back_ssm.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from teacher where tno=#{tno}")
    public Teacher findTeacherByTno(String tno);
    @Select("select * from teacher where account=#{account}")
    public Teacher findTeacherByAccount(String account);
    @Insert("INSERT INTO teacher (tno, name, college, sex, title, account) " +
            "VALUES (#{tno}, #{name}, #{college}, #{sex}, #{title}, #{account})")
    public int addTeacher(Teacher teacher);
}
