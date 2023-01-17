package com.example.springboot100.user.service;

import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateRequest;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateResponse;

import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateResponse;

public interface UserService {

    UserCreateResponse addUser(UserCreateRequest request);

    UserUpdateResponse updateUser(Long id, UserUpdateRequest request);

    UserDto getUser(Long id);
}
