package com.sparta.teamnews.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.teamnews.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String profilename;
    private String content;
    private String savedNm;
    private String savedPath;
    private String orgNm;
    private Boolean success;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<CommentResponseDto> comment;
    private Integer like;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.profilename = post.getUser().getProfilename();
        this.content = post.getContent();
        this.savedNm = post.getSavedNm();
        this.savedPath = post.getSavedPath();
        this.orgNm = post.getOrgNm();

        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.comment = post.getCommentList()
                .stream()
                .map(CommentResponseDto::new)
                .toList();
        this.like = post.getLikeList().size();
    }

    public PostResponseDto(Boolean success) {
        this.success = success;
    }
}
