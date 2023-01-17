package com.example.springboot100.user.service;

import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateRequest;

import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateResponse;

public interface UserService {

    UserCreateResponse addUser(UserCreateRequest request);

    Object updateUser(Long id, UserUpdateRequest request);
}
