package com.sparta.teamnews.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity     //Entity클래스
@Getter
@Setter
@Table(name="user")  //DB제작시 추가
@NoArgsConstructor  //기본 생성자
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(name = "username", nullable = false)
    String username;
    @Column(name = "password", nullable = false)
    String password;


}
