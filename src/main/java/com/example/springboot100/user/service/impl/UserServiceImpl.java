package com.example.springboot100.user.service.impl;


import com.example.springboot100.user.domain.dto.UserCreateRequestDto;
import com.example.springboot100.user.domain.repository.UserRepository;
import com.example.springboot100.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public Object addUser(UserCreateRequestDto request) {
        return null;
    }
}
