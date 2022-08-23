package com.example.jwt2.controller.dto;

import com.example.jwt2.entity.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public
class PostsResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private String createdDate, modifiedDate;
    private List<CommentResponseDto> comments;     /* Entity -> Dto*/
    private MemberDto member;

    public PostsResponseDto(Post posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.writer = posts.getAuthor();
        this.content = posts.getContent();
        this.createdDate = posts.getCreatedAt().toString();
        this.modifiedDate = posts.getModifiedAt().toString();
        this.comments = posts.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
        this.member = new MemberDto(posts.getMember());
    }
}
