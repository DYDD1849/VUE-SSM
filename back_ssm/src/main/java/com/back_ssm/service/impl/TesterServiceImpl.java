package com.back_ssm.service.impl;

import com.back_ssm.mapper.TesterMapper;
import com.back_ssm.pojo.Tester;
import com.back_ssm.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TesterServiceImpl implements TesterService{
    @Autowired
    private TesterMapper testerMapper;
    public List<Tester> findTesters(){
        System.out.println("第二次成功");
        return testerMapper.findTester();
    }
}
