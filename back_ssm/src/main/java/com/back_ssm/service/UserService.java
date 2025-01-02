package com.back_ssm.service;

import com.back_ssm.pojo.User;

public interface UserService {
    public User findUserByAccountPassword(User user);
    public int addUser(User user);
    public User findByAccount(User user);
}
