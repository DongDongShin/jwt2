package com.example.jwt2.controller.dto;

import com.example.jwt2.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {


    private Long id;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private String nickname;
    private Long postsId;


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.nickname = comment.getAuthor();
        this.createdAt=comment.getCreatedAt();
        this.modifiedAt=comment.getModifiedAt();
        this.postsId = comment.getPosts().getId();
    }


}
