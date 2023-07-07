package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.ApiResponseDto;
import com.sparta.teamnews.dto.CommentRequestDto;
import com.sparta.teamnews.security.UserDetailsImpl;
import com.sparta.teamnews.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ResponseBody
    @PostMapping("/comment")         //댓글 작성
    public ApiResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.createComment(commentRequestDto, userDetails);
        return new ApiResponseDto("댓글 작성 완료", HttpStatus.OK.value());
    }

    @ResponseBody
    @PutMapping("/comment/{id}")            //댓글 수정 수정
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.updateComment(id, commentRequestDto, userDetails);
    }

    @ResponseBody
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.deleteComment(id, userDetails.getUser());
    }


}
