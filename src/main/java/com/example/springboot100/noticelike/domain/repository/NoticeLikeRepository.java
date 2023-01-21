package com.example.springboot100.noticelike.domain.repository;

import com.example.springboot100.noticelike.domain.entity.NoticeLike;
import com.example.springboot100.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeLikeRepository extends JpaRepository<NoticeLike, Long> {
    List<NoticeLike> findByUser(User user);
}
