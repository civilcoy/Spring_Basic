package com.sparta.spring_basic.repository;

import com.sparta.spring_basic.dto.PostResponseDto;
import com.sparta.spring_basic.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostResponseDto> findAllByOrderByModifiedAtDesc();
}
