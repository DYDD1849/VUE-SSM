package com.back_ssm.mapper;

import com.back_ssm.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageMapper {
    @Select("select * from chat where sender=#{sender} and receiver=#{receiver}")
    public List<Message> findMessageBySenderReceiver(Message message);
    @Select("select * from chat where sender=#{receiver} and receiver=#{sender}")
    public List<Message> findMessageBySenderReceiver2(Message message);
    @Insert("insert into chat values(#{sender},#{receiver},#{msg},#{date},#{isread})")
    public int addMessage(Message message);
    @Select("select * from chat where isread='false' and receiver=#{receiver} ")
    public List<Message> findIsReadMessageByReceiver(Message message);
    @Update("update chat set isread='true' where receiver=#{receiver}")
    public int UpdateMessageIsReadByReceiver(Message message);
}
