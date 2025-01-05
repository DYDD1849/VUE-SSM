package com.back_ssm.controller;

import com.back_ssm.pojo.Message;
import com.back_ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class MessageController {
    @Autowired
    MessageService messageService;
    @PostMapping(value = "/findMessage")
    @ResponseBody
    public List<Message> findMessageBySenderReceiver(@RequestBody Message message){
        return messageService.findMessageBySenderReceiver(message);
    }
    @PostMapping(value = "/addMessage")
    @ResponseBody
    public int addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }
}
