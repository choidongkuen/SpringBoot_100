package com.example.springboot100.user.domain.repository;

import com.example.springboot100.user.domain.entity.User;
import com.example.springboot100.user.domain.entity.UserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, Long> {

    List<UserLoginHistory> findByUser(User user);
}
