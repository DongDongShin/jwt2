package com.example.jwt2.service;

import com.example.jwt2.controller.dto.CommentResponseDto;
import com.example.jwt2.controller.dto.PostsResponseDto;
import com.example.jwt2.controller.dto.ResponseDto;
import com.example.jwt2.entity.Comment;
import com.example.jwt2.entity.Post;
import com.example.jwt2.repository.CommentRepository;
import com.example.jwt2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class AllService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    @Transactional(readOnly = true)
    public ResponseDto<?> getAllPost() {
        List<Post> list = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostsResponseDto> dtolist = new ArrayList<>();

        for (Post temp : list) {
            PostsResponseDto postsResponseDto = new PostsResponseDto(temp);
            dtolist.add(postsResponseDto);
        }

        return ResponseDto.success(dtolist);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getPost(Long id) {//해당 ID의 게시글을 가져감
        Optional<Post> optionalPost = postRepository.findById(id);


        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시글 ID가 존재하지 않습니다.");
        }
        PostsResponseDto postsResponseDto = new PostsResponseDto(optionalPost.get());
        return ResponseDto.success(postsResponseDto);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getAllComment() {
        List<Comment> list = commentRepository.findAllByOrderByCreatedAtDesc();
        List<CommentResponseDto> dtolist = new ArrayList<>();
        for (Comment temp : list) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(temp);
            dtolist.add(commentResponseDto);
        }

        return ResponseDto.success(dtolist);
    }

}
