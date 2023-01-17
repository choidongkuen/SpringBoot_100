package com.example.springboot100.user.service;

import com.example.springboot100.user.domain.dto.UserCreateRequestDto;

public interface UserService {
    
    Object addUser(UserCreateRequestDto request);
}
