package com.zeta.springboot.repository;

import com.zeta.springboot.model.Comment;
import com.zeta.springboot.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CommentRepository extends JpaRepository<Comment, Long> { }