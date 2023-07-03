package com.sparta.teamnews.dto;

import com.sparta.teamnews.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    String title;
    String image;
    String username;
    String content;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post){


    }
}
