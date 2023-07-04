package com.sparta.teamnews.service;

import com.sparta.teamnews.dto.PostResponseDto;
import com.sparta.teamnews.entity.Post;
import com.sparta.teamnews.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    public List<PostResponseDto> getAllPost() {

        return postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPost(Long id) {

        Post post = findPost(id);

        return new PostResponseDto(post);
    }



    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 게시물은 존재하지 않습니다.")
        );
    }
}

    public PostResponseDto creatPost(PostRequestDto requestDto, User user) { //게시물 생성

        Post post = postRepository.save(new Post(requestDto, user));
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(User user, Long id, PostRequestDto requestDto) {
        Post post = findPost(id);

        if (!post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        post.setTitle(requestDto.getTitle());
        post.setImage(requestDto.getImage());
        post.setContent(requestDto.getContent());

        return new PostResponseDto(post);

    }

    public void deletePost(Long id, User user) {
        Post post = findPost(id);

        if (!post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        postRepository.delete(post);
    }


    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글은 존재하지 않습니다."));
    }
}

