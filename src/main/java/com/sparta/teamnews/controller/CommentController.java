package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.CommentRequestDto;
import com.sparta.teamnews.security.UserDetailsImpl;
import com.sparta.teamnews.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @PostMapping("/commet")         //댓글 작성
    public String createComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){

        return commentService.createComment(commentRequestDto, userDetails);
    }
    @PutMapping("/comment/{id}")            //댓글 수정
    public String updateComment(){
        return "/redirect:/api/post/1";//1 자리에 id들어가야함
    }
    @DeleteMapping("/comment/{id}")
    public String deleteComment(){
        return "/redirect:/api/post/1";//1 자리에 id들어가야함
    }


}
