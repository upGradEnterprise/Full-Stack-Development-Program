package com.zeta.springboot.controller;

import com.zeta.springboot.model.Comment;
import com.zeta.springboot.model.SuccessMessage;
import com.zeta.springboot.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(
        produces = {"application/json", "application/xml"},
        consumes = {"application/json", "application/xml"}
)
@RestController public class CommentController {
    @Autowired private ICommentService commentService;

    @PostMapping public ResponseEntity<SuccessMessage> postComment(@PathVariable Long messageId, @RequestBody Comment comment) {
        Long id = commentService.saveComment(messageId, comment);
        return new ResponseEntity<>(new SuccessMessage(String.format("Comment posted with id %s", id)), HttpStatus.CREATED);
    }

    @GetMapping public ResponseEntity<List<Comment>> getComments(@PathVariable Long messageId) {
        return new ResponseEntity<>(commentService.getAllComments(messageId), HttpStatus.OK);
    }

    @GetMapping("/{commentId}") public ResponseEntity<Comment> getCommentById(@PathVariable Long messageId, @PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(messageId, commentId), HttpStatus.FOUND);
    }

    @PutMapping public ResponseEntity<Comment> updateComment(@PathVariable Long messageId, @RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.updateComment(messageId, comment), HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}") public ResponseEntity<SuccessMessage> deleteComment(@PathVariable Long messageId, @PathVariable Long commentId) {
        commentService.deleteComment(messageId, commentId);
        return new ResponseEntity<>(new SuccessMessage(String.format("Comment deleted with id %s", commentId)), HttpStatus.OK);
    }
}