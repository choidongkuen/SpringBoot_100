package com.example.springboot100.user.service.impl;


import com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateResponse;
import com.example.springboot100.user.domain.entity.User;
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
    public UserCreateResponse addUser(UserCreateRequest request) {

        return UserCreateResponse.from(userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword())
                .phone(request.getPhone())
                .build()
        ));
    }
}
