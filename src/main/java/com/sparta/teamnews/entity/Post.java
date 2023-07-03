package com.sparta.teamnews.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Entity     //Entity클래스
@Getter
@Setter
@Table(name="news")  //DB제작시 추가
@NoArgsConstructor  //기본 생성자
public class Post extends Timestamped{ //news 게시글 Entity

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;    //id
    @Column(name="title")
    String title;   //제목
    @Column(name = "image", nullable = false)
    URL image;
    @Column(name ="content",nullable = false, length = 500)
    String content;//작성내용
//    @Column(name="user_id",nullable = false)
//    long user_id;
    //List<Comment>??

}
