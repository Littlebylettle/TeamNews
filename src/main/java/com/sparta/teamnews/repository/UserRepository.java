package com.sparta.teamnews.repository;

import com.sparta.teamnews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //JPA쿼리 작성
}