package com.example.springboot100.admin.service;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.user.domain.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    UserInfoResponseDto getUserInfo();

    ResponseMessage getUserDetail(Long id);

    List<UserDto> findUser(String email);

    ResponseMessage userStatus(Long id, UserStatus userStatus);

    ResponseMessage deleteUser(Long id);


    List<UserLoginHistoryDto> userLoginHistory(Long id);

    ResponseEntity<Object> userLock(Long id);

    UserSummary getUserSummary();

    List<UserNoticeCountDto> userNoticeCount();

    List<UserLogDto> userLogCount();
}
