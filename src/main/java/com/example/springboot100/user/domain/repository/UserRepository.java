package com.example.springboot100.user.domain.repository;

import com.example.springboot100.user.domain.dto.UserStatus;
import com.example.springboot100.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndPassword(Long id, String password);

    Optional<User> findByNameAndPhone(String userName, String phone);

    Optional<User> findByEmail(String email);

    List<User> findByEmailContains(String email);

    long countByUserStatus(UserStatus userStatus);
}
