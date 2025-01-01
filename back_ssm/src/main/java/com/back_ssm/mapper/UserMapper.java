package com.back_ssm.mapper;

import com.back_ssm.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where user_id=#{user.userId}")
    public User findUser(User user);
}
