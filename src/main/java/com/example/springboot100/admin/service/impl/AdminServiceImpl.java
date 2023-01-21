package com.example.springboot100.admin.service.impl;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.admin.service.AdminService;
import com.example.springboot100.exception.ErrorCode;
import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.dto.UserStatus;
import com.example.springboot100.user.domain.entity.User;
import com.example.springboot100.user.domain.repository.UserRepository;
import com.example.springboot100.user.exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.springboot100.exception.ErrorCode.NO_FOUND_USER;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    @Override
    public ResponseMessage getUserDetail(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ErrorCode.NO_FOUND_USER));

        return ResponseMessage.of(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> findUser(String email) {

        return userRepository.findByEmailContains(email)
                     .stream()
                     .map(UserDto::from)
                     .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ResponseMessage userStatus(Long id, UserStatus userStatus) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(NO_FOUND_USER));

        return ResponseMessage.of(user.setUserStatus(userStatus));
    }
}
