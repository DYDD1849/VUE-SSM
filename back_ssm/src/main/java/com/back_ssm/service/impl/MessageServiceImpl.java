package com.back_ssm.service.impl;

import com.back_ssm.mapper.MessageMapper;
import com.back_ssm.pojo.Message;
import com.back_ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Message> findMessageBySenderReceiver(Message message) {
        List<Message> merge= messageMapper.findMessageBySenderReceiver(message);
        messageMapper.UpdateMessageIsReadByReceiver(message);
        merge.addAll(messageMapper.findMessageBySenderReceiver2(message));
        return merge;
    }

    @Override
    public int addMessage(Message message) {

        Timestamp now = new Timestamp(System.currentTimeMillis());

        // 创建一个SimpleDateFormat对象来格式化日期时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化Timestamp对象
        String formattedDateTime = sdf.format(now);
        message.setIsread("false");
        message.setDate(formattedDateTime);
        return messageMapper.addMessage(message);
    }

    @Override
    public List<Message> findIsReadMessageByReceiver(Message message) {
        return messageMapper.findIsReadMessageByReceiver(message);
    }
}
