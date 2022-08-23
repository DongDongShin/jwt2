package com.example.jwt2.entity;


import com.example.jwt2.controller.dto.CommentDto;
import com.example.jwt2.controller.dto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
@Table(name = "comment")
@Entity
public class Comment extends Timestamped  {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name="post_id",nullable = false)
    private Post posts;//얘의 id


    public void update(CommentDto commentDto) {
        this.comment =commentDto.getComment();
    }
}
