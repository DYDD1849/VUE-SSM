package com.back_ssm.controller;

import com.back_ssm.pojo.Message;
import com.back_ssm.pojo.combination.MessageName;
import com.back_ssm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

    @PostMapping(value = "/findNoReadMessage")
    @ResponseBody
    public String findIsReadMessageByReceiver(@RequestBody Message message){
        if(messageService.findIsReadMessageByReceiver(message).isEmpty())return "没有未读信息1";
        return "有未读信息2";
    }

    @PostMapping(value = "/findSender")
    @ResponseBody
    public List<MessageName> findSender(@RequestBody Message message){
        return messageService.findSenderByStudentTeacher(message);
    }

}
