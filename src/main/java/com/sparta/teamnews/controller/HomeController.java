package com.sparta.teamnews.controller;

import com.sparta.teamnews.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/api/user/login-page")
    public String loginPage() { return "login";}

    @GetMapping("/api/user/signup")
    public String signupPage() { return "signup";}
    @GetMapping("/api/user/new-post")
    public String newPostPage() { return "newpost";}
}