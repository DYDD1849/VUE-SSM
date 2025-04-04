package com.back_ssm.mapper;

import com.back_ssm.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where account= #{account} and password= #{password}")
    public User findUserByAccountPassword(User user);
    @Select("select * from user where account= #{account}")
    public User findUserByAccount(User user);
    @Insert("insert into user values(#{account},#{password},#{role})")
    public int addUser(User user);
}
