package com.sparta.teamnews.service;

import com.sparta.teamnews.dto.CommentRequestDto;
import com.sparta.teamnews.dto.CommentResponseDto;
import com.sparta.teamnews.entity.Comment;
import com.sparta.teamnews.entity.Post;
import com.sparta.teamnews.repository.CommentRepository;
import com.sparta.teamnews.repository.UserRepository;
import com.sparta.teamnews.security.UserDetailsImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentService
{
    private final CommentRepository commentRepository;
    private final PostService postService;
    public CommentService(CommentRepository commentRepository,PostService postService){
        this.commentRepository = commentRepository;
        this.postService = postService;

    }

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto, UserDetailsImpl userDetails) {

        Post post = postService.findPost(commentRequestDto.getPostId());
        Comment comment = new Comment(commentRequestDto.getBody(),post,userDetails.getUser());

        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);

        return commentResponseDto;
    }
}
