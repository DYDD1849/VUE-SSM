package com.back_ssm.service.impl;

import com.back_ssm.mapper.UserMapper;
import com.back_ssm.pojo.User;
import com.back_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(User user) {

        return userMapper.findUser(user);
    }
}
