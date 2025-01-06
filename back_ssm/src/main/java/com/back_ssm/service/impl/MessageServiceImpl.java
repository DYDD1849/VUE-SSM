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
        List<Message> merge= messageMapper.findMessageBySenderReceiver(message);
        merge.addAll(messageMapper.findMessageBySenderReceiver2(message));
        return merge;
    }

    @Override
    public int addMessage(Message message) {
        message.setIsread("false");
        return messageMapper.addMessage(message);
    }
}
