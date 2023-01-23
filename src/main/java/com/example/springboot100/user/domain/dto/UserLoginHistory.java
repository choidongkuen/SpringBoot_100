package com.example.springboot100.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class UserLoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String email;

    @Column
    private String userName;

    @Column
    private LocalDateTime loginDate;

    @Column
    private String ipAddress;
}
