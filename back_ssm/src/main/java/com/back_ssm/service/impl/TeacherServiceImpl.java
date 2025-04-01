package com.back_ssm.service.impl;

import com.back_ssm.mapper.TeacherMapper;
import com.back_ssm.pojo.Teacher;
import com.back_ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByTno(String tno) {
        return teacherMapper.findTeacherByTno(tno);
    }

    @Override
    public Teacher findTeacherByAccount(String account) {
        return teacherMapper.findTeacherByAccount(account);
    }

    @Override
    public int altTeacher(Teacher teacher) {
        return teacherMapper.altTeacher(teacher);
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }

    @Override
    public List<Teacher> searchTeacherByName(String name) {
        return teacherMapper.searchTeacherByName(name);
    }
}
