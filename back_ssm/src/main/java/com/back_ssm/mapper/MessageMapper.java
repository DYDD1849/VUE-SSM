package com.back_ssm.mapper;

import com.back_ssm.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
    @Select("select * from chat where sender=#{sender} and receiver=#{receiver}")
    public List<Message> findMessageBySenderReceiver(Message message);
    @Insert("insert into chat values(#{sender},#{receiver},#{msg},#{date},#{isread})")
    public int addMessage(Message message);
}
