package com.sparta.teamnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/api/user/login")
    public String loginPage() { return "login";}

    @GetMapping("/api/user/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/api/user/mypage")
    public String myPage() {
        return "mypage";
    }

    @GetMapping("/api/passwordchange")
    public String passwordChange() {
        return "passwordchange";
    }
}