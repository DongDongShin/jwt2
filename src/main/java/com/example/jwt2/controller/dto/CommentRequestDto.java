package com.example.jwt2.controller.dto;


import com.example.jwt2.entity.Comment;
import com.example.jwt2.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private Long id;
    private String comment;
    private Post posts;

    private String author;

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .posts(posts)
                .author(author)
                .build();
        return comments;
    }

}
