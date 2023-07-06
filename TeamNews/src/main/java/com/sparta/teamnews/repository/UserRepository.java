package com.sparta.teamnews.repository;

import com.sparta.teamnews.entity.Post;
import com.sparta.teamnews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //JPA쿼리 작성
    Optional<User> findByUsername(String username);
}
