package com.example.jwt2.controller;

import com.example.jwt2.controller.dto.PostRequestDto;
import com.example.jwt2.controller.dto.ResponseDto;
import com.example.jwt2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/post/create")
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto ) {
        return postService.createPost(requestDto);
    }

    @PutMapping("/post/modify/{id}")
    public ResponseDto<?> modifyPost(@RequestBody PostRequestDto requestDto,@PathVariable Long id) {
        return postService.modifyPost(requestDto,id);
    }

    @DeleteMapping ("/post/delete/{id}")
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        System.out.println("dsds");
        return postService.deletePost(id);
    }

}
