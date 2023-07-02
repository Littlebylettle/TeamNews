package com.sparta.teamnews.repository;

import com.sparta.teamnews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
