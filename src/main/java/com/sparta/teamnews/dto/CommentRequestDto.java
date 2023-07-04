package com.sparta.teamnews.dto;

import com.sparta.teamnews.entity.Post;
import com.sparta.teamnews.entity.User;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    Long postId;
    String body;
    User user;
    Post post;

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
