package com.example.springboot100.admin.service;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.dto.UserLoginHistoryDto;
import com.example.springboot100.user.domain.dto.UserStatus;

import java.util.List;

public interface AdminService {
    UserInfoResponseDto getUserInfo();

    ResponseMessage getUserDetail(Long id);

    List<UserDto> findUser(String email);

    ResponseMessage userStatus(Long id, UserStatus userStatus);

    ResponseMessage deleteUser(Long id);


    List<UserLoginHistoryDto> userLoginHistory(Long id);

}
