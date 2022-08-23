package com.example.jwt2.repository;


import java.util.List;
import java.util.Optional;

import com.example.jwt2.controller.dto.PostsResponseDto;
import com.example.jwt2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
  List<Post> findAllByOrderByCreatedAtDesc();

}
