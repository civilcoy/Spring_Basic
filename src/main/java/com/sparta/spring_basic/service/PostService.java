package com.sparta.spring_basic.service;

import com.sparta.spring_basic.dto.DeleteRequestDto;
import com.sparta.spring_basic.dto.DeleteResponseDto;
import com.sparta.spring_basic.dto.PostRequestDto;
import com.sparta.spring_basic.dto.PostResponseDto;
import com.sparta.spring_basic.entity.Post;
import com.sparta.spring_basic.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회하려는 게시물이 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("수정하려는 게시물이 존재하지 않습니다.")
        );
        post.update(postRequestDto);
        return new PostResponseDto(post);
    }

    @Transactional
    public DeleteResponseDto deletePost(Long id, DeleteRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("수정하려는 게시물이 존재하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.deleteById(id);
            return new DeleteResponseDto(true);
        }
        return new DeleteResponseDto(false);
    }
}
