package com.sparta.teamnews.service;

import com.sparta.teamnews.repository.CommentRepository;
import com.sparta.teamnews.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService
{
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;

    }
}
