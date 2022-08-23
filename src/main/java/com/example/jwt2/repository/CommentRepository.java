package com.example.jwt2.repository;

import com.example.jwt2.entity.Comment;
import com.example.jwt2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();
}
