package com.back_ssm.service;

import com.back_ssm.pojo.Message;
import com.back_ssm.pojo.combination.MessageName;

import java.util.List;

public interface MessageService {
    public List<Message> findMessageBySenderReceiver(Message message);
    public int addMessage(Message message);
    public List<Message> findIsReadMessageByReceiver(Message message);
    public List<MessageName> findSenderByStudentTeacher(Message message);
}
