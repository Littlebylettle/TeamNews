package com.sparta.teamnews.controller;

import com.sparta.teamnews.dto.PwdRequestDto;
import com.sparta.teamnews.dto.SignupRequestDto;
import com.sparta.teamnews.dto.UserRequestDto;
import com.sparta.teamnews.dto.UserResponseDto;
import com.sparta.teamnews.security.UserDetailsImpl;
import com.sparta.teamnews.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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
    public String signupUser(SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login-page";
    }

    @PostMapping("/user/login")     //로그인
    public UserResponseDto loginUser(UserRequestDto userRequestDto, HttpServletResponse response) {
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
