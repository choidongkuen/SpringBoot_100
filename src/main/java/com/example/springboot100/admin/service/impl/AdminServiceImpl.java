package com.example.springboot100.admin.service.impl;

import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.admin.service.AdminService;
import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public UserInfoResponseDto getUserInfo() {

        return UserInfoResponseDto.builder()
                .userList(userRepository.findAll()
                            .stream()
                            .map(UserDto::from)
                            .collect(Collectors.toList())
                )
                .totalUserCount(userRepository.count())
                .build();

    }
}
