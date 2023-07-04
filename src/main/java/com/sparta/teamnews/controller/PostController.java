package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.PostRequestDto;
import com.sparta.teamnews.dto.PostResponseDto;
import com.sparta.teamnews.security.UserDetailsImpl;
import com.sparta.teamnews.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")// 전체 게시글 조회
    public List<PostResponseDto> getAllNews() {
        //service이용해서 내부 메소드 실행하기
        return null;
    }

    @GetMapping("/post/{id}")       //게시글 단건 조회
    public PostResponseDto getNews() {
        //댓글정보까지 같이 받아서 뿌려줘야할듯 함...

        return null;
    }

    @PostMapping("/post")    // 게시글 생성
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.creatPost(requestDto, userDetails.getUser());
    }

    @PutMapping("/post/{id}")    //게시글 수정
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.updatePost(userDetails.getUser(), id, requestDto);
    }

    @DeleteMapping("/post/{id}")    //게시글 삭제
    public PostResponseDto deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.deletePost(id, userDetails.getUser());
        return new PostResponseDto(true);
    }
}
