package com.zeta.springboot.service;

import com.zeta.springboot.exception.CommentNotFoundException;
import com.zeta.springboot.exception.MessageNotFoundException;
import com.zeta.springboot.model.Comment;
import com.zeta.springboot.model.Message;
import com.zeta.springboot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service public class CommentService implements ICommentService {
    @Autowired private CommentRepository commentRepository;
    @Autowired private IMessageService messageService;

    @Override public Long saveComment(Long messageId, Comment comment) throws MessageNotFoundException {
        if(messageService.getMessageById(messageId) == null) {
            throw new MessageNotFoundException("Message with id " + messageId + " not found");
        }
        comment.setMessageId(messageId);
        comment.setCreatedDate(LocalDateTime.now());
        comment.setModifiedDate(LocalDateTime.now());
        return commentRepository.save(comment).getId();
    }

    @Override public Comment getCommentById(Long messageId, Long commentId) throws MessageNotFoundException, CommentNotFoundException {
        if(messageService.getMessageById(messageId) == null) {
            throw new MessageNotFoundException("Message with id " + commentId + " not found");
        }
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(
                        String.format("Comment with id %s not found", commentId)
                ));
    }

    @Override public List<Comment> getAllComments(Long messageId) throws MessageNotFoundException {
        if(messageService.getMessageById(messageId) == null) {
            throw new MessageNotFoundException("Message with id " + messageId + " not found");
        }
        return commentRepository.findAll().stream().filter(comment ->
                comment.getMessageId().equals(messageId)).collect(Collectors.toList());
    }

    @Override public Comment updateComment(Long messageId, Comment comment) throws MessageNotFoundException, CommentNotFoundException {
        if(messageService.getMessageById(messageId) == null) {
            throw new MessageNotFoundException("Message with id " + messageId + " not found");
        }
        if (commentRepository.existsById(comment.getId())) {
            Comment oldComment = getCommentById(messageId, comment.getId());
            comment.setCreatedDate(oldComment.getCreatedDate());
            comment.setModifiedDate(LocalDateTime.now());
            return commentRepository.save(comment);
        }
        throw new CommentNotFoundException(String.format("Comment with id %s not found.", comment.getId()));
    }

    @Override public void deleteComment(Long messageId, Long commentId) throws MessageNotFoundException, CommentNotFoundException {
        if(messageService.getMessageById(messageId) == null) {
            throw new MessageNotFoundException("Message with id " + messageId + " not found.");
        }
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
        } else throw new CommentNotFoundException(String.format("Comment with id %s not found.", commentId));    }
}