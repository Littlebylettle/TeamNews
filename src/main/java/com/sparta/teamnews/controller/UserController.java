package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.UserResponseDto;
import com.sparta.teamnews.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/user/signup")    //회원가입
    public String signupUser(){
        return "회원가입 완료";
    }
    @PostMapping("/user/login")     //로그인
    public String loginUser(){

        return "로그인 완료";
    }
    @PostMapping("/user/logout")    //로그아웃
    public String logoutUser(){
        return "로그아웃 완료";
    }
    @PutMapping("/profile")        //프로필정보 수정
    public UserResponseDto updateProfile(){

        return null;
    }
    @PutMapping("/profile/password")        //비밀번호 수정
    public UserResponseDto updatePassword(){

        return null;
    }
}