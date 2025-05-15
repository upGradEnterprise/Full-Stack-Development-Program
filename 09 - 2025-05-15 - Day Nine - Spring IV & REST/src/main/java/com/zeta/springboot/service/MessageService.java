package com.zeta.springboot.service;

import com.zeta.springboot.exception.MessageNotFoundException;
import com.zeta.springboot.model.Message;
import com.zeta.springboot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service public class MessageService implements IMessageService {
    @Autowired private MessageRepository messageRepository;

    @Override public Long saveMessage(Message message) {
        message.setCreatedDate(LocalDateTime.now());
        message.setModifiedDate(LocalDateTime.now());
        return messageRepository.save(message).getId();
    }

    @Override public Message getMessageById(Long id) throws MessageNotFoundException {
        return messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(
                        String.format("Message with id %s not found", id)
                ));
    }

    @Override public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override public Message updateMessage(Message message) throws MessageNotFoundException {
        if (messageRepository.existsById(message.getId())) {
            Message oldMessage = getMessageById(message.getId());
            message.setCreatedDate(oldMessage.getCreatedDate());
            message.setModifiedDate(LocalDateTime.now());
            return messageRepository.save(message);
        }
        throw new MessageNotFoundException(String.format("Message with id %s not found", message.getId()));
    }

    @Override public void deleteMessage(Long id) throws MessageNotFoundException {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
        } else throw new MessageNotFoundException(String.format("Message with id %s not found", id));
    }
}