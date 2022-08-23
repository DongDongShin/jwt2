package com.example.jwt2.controller;


import com.example.jwt2.controller.dto.CommentDto;
import com.example.jwt2.controller.dto.CommentRequestDto;
import com.example.jwt2.controller.dto.ResponseDto;
import com.example.jwt2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    final private CommentService commentService;
    @PostMapping("/create/{id}")
    public ResponseDto<?> create_comment(@RequestBody CommentRequestDto commentDto, @PathVariable Long id) {

        return commentService.createComment(commentDto,id);
    }
    @PutMapping("/modify/{id}")
    public ResponseDto<?> modify_comment(@RequestBody CommentDto commentDto, @PathVariable Long id) {

        return commentService.modifyComment(commentDto,id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto<?> delete_comment(@PathVariable Long id) {
        System.out.println("으악");
        return commentService.deleteComment(id);
    }
}
