package com.back_ssm.mapper;

import com.back_ssm.pojo.Tester;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TesterMapper {
    @Select("select * from tester")
    List<Tester> findTester();
}
