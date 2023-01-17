package com.example.springboot100.user.service;

import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateResponse;

public interface UserService {

    UserCreateResponse addUser(UserCreateRequest request);

}
