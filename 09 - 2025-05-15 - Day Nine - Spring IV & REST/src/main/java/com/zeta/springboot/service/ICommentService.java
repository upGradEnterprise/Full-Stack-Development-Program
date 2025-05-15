package com.zeta.springboot.service;

import com.zeta.springboot.exception.CommentNotFoundException;
import com.zeta.springboot.exception.MessageNotFoundException;
import com.zeta.springboot.model.Comment;

import java.util.List;

public interface ICommentService {
    Long saveComment(Long messageId, Comment comment) throws MessageNotFoundException;
    Comment getCommentById(Long messageId, Long commentId) throws MessageNotFoundException, CommentNotFoundException;
    List<Comment> getAllComments(Long messageId) throws MessageNotFoundException;
    Comment updateComment(Long messageId, Comment comment) throws MessageNotFoundException, CommentNotFoundException;
    void deleteComment(Long messageId, Long commentId) throws MessageNotFoundException, CommentNotFoundException;
}