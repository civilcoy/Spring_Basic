package com.sparta.spring_basic.controller;

import com.sparta.spring_basic.dto.DeleteRequestDto;
import com.sparta.spring_basic.dto.DeleteResponseDto;
import com.sparta.spring_basic.dto.PostRequestDto;
import com.sparta.spring_basic.dto.PostResponseDto;
import com.sparta.spring_basic.entity.Post;
import com.sparta.spring_basic.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class PostController {
    private final PostService postService;

    @PostMapping("/api/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

//    @DeleteMapping("/api/post/{id}")
//    public PostResponseDto deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.deletePost(id, requestDto);
//    }

    @DeleteMapping("api/post/{id}")
    public DeleteResponseDto deletePost(@PathVariable Long id, @RequestBody DeleteRequestDto requestDto) {
        return postService.deletePost(id, requestDto);
    }



}
