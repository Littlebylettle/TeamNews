package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.*;
import com.sparta.teamnews.security.UserDetailsImpl;
import com.sparta.teamnews.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")    //회원가입
    public String signupUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login";
    }

    @ResponseBody
    @PostMapping("/user/login")     //로그인
    public ApiResponseDto loginUser(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response) {
        userService.loginUser(userRequestDto, response);
        return new ApiResponseDto("로그인완료", HttpStatus.OK.value());
    }

    @ResponseBody
    @PostMapping("/user/logout")    //로그아웃
    public UserResponseDto logoutUser(HttpServletRequest request) {
        return userService.logoutUser(request);
    }

    @ResponseBody
    @PutMapping("/profile")     //프로필정보 수정
    public ApiResponseDto updateProfile(@RequestBody ProfileRequestDto profileRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.updateProfile(profileRequestDto, userDetails);
        return new ApiResponseDto("프로필 업데이트 완료", HttpStatus.OK.value());
    }

    @ResponseBody
    @PutMapping("/profile/password")       //비밀번호 수정
    public UserResponseDto updatePassword(@RequestBody PwdRequestDto pwdRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.updatePassword(pwdRequestDto,userDetails);
    }
}
