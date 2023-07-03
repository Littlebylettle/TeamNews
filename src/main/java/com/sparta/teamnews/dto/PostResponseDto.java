package com.sparta.teamnews.dto;

import com.sparta.teamnews.entity.Post;
import jakarta.persistence.Id;
import lombok.Getter;

import java.net.URL;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    String title;
    URL image;
    String username;
    String content;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post){


    }
}
