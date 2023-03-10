package com.example.springboot100.user.service;

import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.dto.UserFindDto;
import com.example.springboot100.user.domain.dto.UserLoginDto;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateRequest;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateResponse;
import com.example.springboot100.user.domain.dto.UserUpdatePasswordDto;

import javax.servlet.http.HttpServletRequest;

import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import static com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateResponse;

public interface UserService {

    UserCreateResponse addUser(UserCreateRequest request);

    UserUpdateResponse updateUser(Long id, UserUpdateRequest request);

    UserDto getUser(Long id);

    UserUpdatePasswordDto.UserUpdatePasswordResponse updatePassword(Long id, UserUpdatePasswordDto.UserUpdatePasswordRequest request);

    void deleteUser(Long id);

    UserCreateResponse findUser(UserFindDto request);

    void resetUserPassword(Long id);

    Object likeNotice(Long id);

    Object createToken(UserLoginDto request);

    Object refreshToken(String token);
}
