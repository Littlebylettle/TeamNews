package com.sparta.teamnews.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity     //Entity클래스
@Getter
@Table(name="posts")  //DB제작시 추가
@NoArgsConstructor  //기본 생성자
public class Post extends Timestamped{ //news 게시글 Entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //id
  
    @Column(name="title")
    private String title;   //제목


    @Column(name ="content",nullable = false, length = 500)
    private String content;//작성내용

    private String orgNm;

    private String savedNm;

    private String savedPath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE})
    private List<Like> LikeList = new ArrayList<>();


    public Post(String title, String content, String orgNm,String savedNm, String savedPath ,User user) {
        this.title = title;
        this.content = content;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
        this.user = user;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public void setContent(String content) {
        this.content = content;
    }

}
