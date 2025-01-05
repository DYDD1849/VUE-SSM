package com.back_ssm.service;

import com.back_ssm.pojo.Course;
import com.back_ssm.pojo.SnoCourse;

import java.util.List;

public interface CourseService {
    public List<Course> findCourseBySno(String sno);
    public List<Course> findCourseByTno(String tno);
    public List<SnoCourse> findSnoCourseBySno(String sno);
    public List<Course> findAllCourse();
}
