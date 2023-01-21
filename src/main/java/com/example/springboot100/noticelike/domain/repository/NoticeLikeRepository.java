package com.example.springboot100.noticelike.domain.repository;

import com.example.springboot100.noticelike.domain.entity.NoticeLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeLikeRepository extends JpaRepository<NoticeLike, Long> {
}
