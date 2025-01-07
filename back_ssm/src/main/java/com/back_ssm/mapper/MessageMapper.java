package com.back_ssm.mapper;

import com.back_ssm.pojo.Message;
import com.back_ssm.pojo.combination.MessageName;
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
    @Select("SELECT teacher.account AS sender, teacher.name AS senderName FROM chat JOIN teacher ON teacher.account = chat.sender WHERE chat.receiver = #{receiver} GROUP BY teacher.account, teacher.name")
    public List<MessageName> findSenderByStudent(Message message);
    @Select("SELECT student.account AS sender, student.name AS senderName FROM chat JOIN student ON student.account = chat.sender WHERE chat.receiver = #{receiver} GROUP BY student.account, student.name")
    public List<MessageName> findSenderByTeacher(Message message);
}
