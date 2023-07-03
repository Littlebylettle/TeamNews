package com.sparta.teamnews.repository;

import com.sparta.teamnews.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //JPA 쿼리 작성
}
