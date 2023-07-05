package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.PwdRequestDto;
import com.sparta.teamnews.dto.SignupRequestDto;
import com.sparta.teamnews.dto.UserRequestDto;
import com.sparta.teamnews.dto.UserResponseDto;
import com.sparta.teamnews.security.UserDetailsImpl;
import com.sparta.teamnews.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")    //회원가입
    public String signupUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "회원가입 완료";
    }

    @PostMapping("/user/login")     //로그인
    public UserResponseDto loginUser(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response) {
        return userService.loginUser(userRequestDto, response);
    }

    @PostMapping("/user/logout")    //로그아웃
    public UserResponseDto logoutUser(HttpServletRequest request) {
        return userService.logoutUser(request);
    }

    @PutMapping("/profile")        //프로필정보 수정
    public UserResponseDto updateProfile() {

        return null;
    }

    @PutMapping("/profile/password")        //비밀번호 수정
    public UserResponseDto updatePassword(@RequestBody PwdRequestDto pwdRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {


        return userService.updatePassword(pwdRequestDto,userDetails);
    }
}
