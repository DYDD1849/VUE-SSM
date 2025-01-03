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
    @Select("select * from course where tno=#{tno})")
    public List<Course> findCourseByTno(String tno);
    @Select("SELECT sc.sno,sc.sscore, course.* FROM sc JOIN course ON sc.cno = course.cno WHERE sc.sno = #{sno}")
    public List<SnoCourse> findSnoCourseBySno(String sno);
}
