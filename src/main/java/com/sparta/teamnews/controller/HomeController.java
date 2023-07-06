package com.sparta.teamnews.controller;

import com.sparta.teamnews.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/api/user/login")
    public String loginPage() { return "login";}

    @GetMapping("/api/user/signup")
    public String signupPage() { return "signup";}

    @GetMapping("/api/user/mypage")
    public String myPage() { return "mypage";}


    @GetMapping("api/post/{id}")       //게시글 단건 조회
    public String getPost(@PathVariable Long id){
        postService.getPost(id);
        return "detail";
    }
    @GetMapping("/api/user/new-post")
    public String newPostPage() { return "newpost";}
}