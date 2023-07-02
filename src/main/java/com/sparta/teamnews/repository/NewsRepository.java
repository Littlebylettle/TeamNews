package com.sparta.teamnews.repository;

import com.sparta.teamnews.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
