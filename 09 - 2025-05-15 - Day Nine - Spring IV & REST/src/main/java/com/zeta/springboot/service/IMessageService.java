package com.zeta.springboot.service;

import com.zeta.springboot.exception.MessageNotFoundException;
import com.zeta.springboot.model.Message;

import java.util.List;

public interface IMessageService {
    Long saveMessage(Message message);
    Message getMessageById(Long id) throws MessageNotFoundException;
    List<Message> getAllMessages();
    Message updateMessage(Message message) throws MessageNotFoundException;
    void deleteMessage(Long id) throws MessageNotFoundException;
}