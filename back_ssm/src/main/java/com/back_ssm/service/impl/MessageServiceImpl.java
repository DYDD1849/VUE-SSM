package com.back_ssm.service.impl;

import com.back_ssm.mapper.MessageMapper;
import com.back_ssm.pojo.Message;
import com.back_ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Message> findMessageBySenderReceiver(Message message) {
        return messageMapper.findMessageBySenderReceiver(message);
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }
}
