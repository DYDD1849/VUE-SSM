package com.back_ssm.service;

import com.back_ssm.pojo.Student;
import com.back_ssm.pojo.Teacher;

public interface TeacherService {
    public int addTeacher(Teacher teacher);
    public Teacher findTeacherByAccount(String account);
}
