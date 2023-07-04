package com.sparta.teamnews.dto;

import com.sparta.teamnews.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private String title;
    private String image;
    private String username;
    private String content;
    private Boolean success;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post){
        this.title = post.getTitle();
        this.image = post.getImage();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createAt = getCreateAt();
        this.modifiedAt = getModifiedAt();
    }

    public PostResponseDto(Boolean success) {
        this.success = success;
    }
}
