package com.sparta.teamnews.dto;


import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private String savedNm;
    private String savedPath;
    private String orgNm;
}

