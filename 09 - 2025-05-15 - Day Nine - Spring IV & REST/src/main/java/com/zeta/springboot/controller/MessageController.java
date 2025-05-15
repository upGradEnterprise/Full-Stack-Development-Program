package com.zeta.springboot.controller;

import com.zeta.springboot.model.ErrorMessage;
import com.zeta.springboot.model.Message;
import com.zeta.springboot.model.SuccessMessage;
import com.zeta.springboot.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(
        value = "/api/messages",
        produces = {"application/json", "application/xml"},
        consumes = {"application/json", "application/xml"}
)
@RestController public class MessageController {
    @Autowired
    private IMessageService messageService;

    @PostMapping
    public ResponseEntity<SuccessMessage> save(@RequestBody Message message) {
        Long id = messageService.saveMessage(message);
        return new ResponseEntity<>(new SuccessMessage(String.format("Message created successfully with id %s.", id)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Message>> findAll() {
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ResponseEntity<?> response = null;
        try {
            response = new ResponseEntity<>(messageService.getMessageById(id), HttpStatus.OK);
        } catch (Exception mne) {
            response = new ResponseEntity<>(new ErrorMessage(String.format("Message with id %s not found.", id), 404), HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Message message) {
        ResponseEntity<?> response = null;
        try {
            response = new ResponseEntity<>(messageService.updateMessage(message), HttpStatus.OK);
        } catch (Exception mne) {
            response = new ResponseEntity<>(new ErrorMessage(String.format("Message with id %s  not found.", message.getId()), 404), HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ResponseEntity<?> response = null;
        try {
            messageService.deleteMessage(id);
            response = new ResponseEntity<>(new SuccessMessage(String.format("Message with id %s deleted.", id)), HttpStatus.OK);
        } catch (Exception mne) {
            response = new ResponseEntity<>(new ErrorMessage(String.format("Message with id %s not found.", id), 404), HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @GetMapping("/{id}/comments")
    public CommentController findComments(@PathVariable Long id) {
        return new CommentController();
    }
}