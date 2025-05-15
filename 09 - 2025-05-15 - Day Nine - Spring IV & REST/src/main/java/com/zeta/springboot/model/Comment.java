package com.zeta.springboot.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Data @JacksonXmlRootElement @Entity(name = "comments") public class Comment {
    @Id @GeneratedValue private Long id;
    private Long messageId;
    private String text;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}