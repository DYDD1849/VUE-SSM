package com.back_ssm.mapper;

import com.back_ssm.pojo.Course;
import com.back_ssm.pojo.SnoCourse;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Select("select * from course")
    public List<Course> findAllCourse();
    @Select("select * from course where cno in (select cno from sc where sno=#{sno})")
    public List<Course> findCourseBySno(String sno);
    @Select("select * from course where tno=#{tno}")
    public List<Course> findCourseByTno(String tno);
//    xml文件配置的接口
    public List<SnoCourse> findSnoCourseBySno(String sno);
}
