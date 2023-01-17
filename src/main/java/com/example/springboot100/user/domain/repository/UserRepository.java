package com.example.springboot100.user.domain.repository;

import com.example.springboot100.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
