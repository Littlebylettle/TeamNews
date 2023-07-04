package com.sparta.teamnews.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity     //Entity클래스
@Getter
@Setter
@Table(name = "user")  //DB제작시 추가
@NoArgsConstructor  //기본 생성자
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "introduce", nullable = false)
    private String introduce;
    @Column(name = "profilename", nullable = false)
    private String profilename;

    public User(String username, String password, String introduce, String profilename) {
        this.username = username;
        this.password = password;
        this.introduce = introduce;
        this.profilename = profilename;
    }
}
