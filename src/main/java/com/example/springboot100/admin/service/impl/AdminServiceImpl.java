package com.example.springboot100.admin.service.impl;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.admin.service.AdminService;
import com.example.springboot100.exception.ErrorCode;
import com.example.springboot100.user.domain.dto.*;
import com.example.springboot100.user.domain.entity.User;
import com.example.springboot100.user.domain.repository.UserCustomRepository;
import com.example.springboot100.user.domain.repository.UserLoginHistoryRepository;
import com.example.springboot100.user.domain.repository.UserRepository;
import com.example.springboot100.user.exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.springboot100.exception.ErrorCode.NO_FOUND_USER;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    private final UserLoginHistoryRepository userLoginHistoryRepository;

    private final UserCustomRepository userCustomRepository;

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

        return ResponseMessage.success(user);
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

        return ResponseMessage.success(user.setUserStatus(userStatus));
    }

    @Transactional
    @Override
    public ResponseMessage deleteUser(Long id) {

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new UserException(NO_FOUND_USER));

        userRepository.delete(user);
        return ResponseMessage.success(user);
    }


    @Override
    public List<UserLoginHistoryDto> userLoginHistory(Long id) {

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new UserException(NO_FOUND_USER));

        return user.getUserLoginHistories()
                   .stream()
                   .map(UserLoginHistoryDto::from)
                   .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ResponseEntity<Object> userLock(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>(
                    ResponseMessage.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST
            );
        }

        if (optionalUser.get().isLockYn()) {
            return new ResponseEntity<>(
                    ResponseMessage.fail("해당 사용자는 이미 접속 제한 상태입니다."), HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                ResponseMessage.success(optionalUser.get().setUserLock()), HttpStatus.OK
        );
    }

    @Override
    public UserSummary getUserSummary() {

        return UserSummary.of(userRepository.countByUserStatus(UserStatus.STOP)
                ,userRepository.countByUserStatus(UserStatus.USING)
                ,userRepository.count()
        );
    }

    @Override
    public List<UserNoticeCountDto> userNoticeCount() {
        return userCustomRepository.findUserNoticeCount();
    }
}
