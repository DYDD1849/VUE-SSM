package com.back_ssm.service.impl;

import com.back_ssm.mapper.CourseMapper;
import com.back_ssm.pojo.Course;
import com.back_ssm.pojo.SnoCourse;
import com.back_ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> findCourseBySno(String sno) {
        return courseMapper.findCourseBySno(sno);
    }

    @Override
    public List<Course> findCourseByTno(String tno) {
        return courseMapper.findCourseByTno(tno);
    }

    @Override
    public List<SnoCourse> findSnoCourseBySno(String sno) {
        return courseMapper.findSnoCourseBySno(sno);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseMapper.findAllCourse();
    }

}
