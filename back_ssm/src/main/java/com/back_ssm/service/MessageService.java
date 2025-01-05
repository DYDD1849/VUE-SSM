package com.back_ssm.service;

import com.back_ssm.pojo.Message;

import java.util.List;

public interface MessageService {
    public List<Message> findMessageBySenderReceiver(Message message);
    public int addMessage(Message message);
}
