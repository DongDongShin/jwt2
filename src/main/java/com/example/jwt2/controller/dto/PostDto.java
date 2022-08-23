package com.example.jwt2.controller.dto;

import com.example.jwt2.entity.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String createdDate, modifiedDate;
    private List<CommentResponseDto> comments;     /* Entity -> Dto*/


    public PostDto(Post posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.content = posts.getContent();
        this.createdDate = posts.getCreatedAt().toString();
        this.modifiedDate = posts.getModifiedAt().toString();
    }


}
