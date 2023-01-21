package com.example.springboot100.user.service.impl;


import com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateResponse;
import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.dto.UserFindDto;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateRequest;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateResponse;
import com.example.springboot100.user.domain.dto.UserUpdatePasswordDto.UserUpdatePasswordRequest;
import com.example.springboot100.user.domain.dto.UserUpdatePasswordDto.UserUpdatePasswordResponse;
import com.example.springboot100.user.domain.entity.User;
import com.example.springboot100.user.domain.repository.UserRepository;
import com.example.springboot100.user.exception.UserException;
import com.example.springboot100.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.example.springboot100.exception.ErrorCode.NO_FOUND_USER;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;


    @Transactional
    @Override
    public UserCreateResponse addUser(UserCreateRequest request) {

        return UserCreateResponse.from(userRepository.save(User.builder()
                               .email(request.getEmail())
                               .name(request.getName())
                               .password(bcryptPasswordEncoder.encode(request.getPassword()))
                               .phone(request.getPhone())
                               .build()
        ));
    }

    @Transactional
    @Override
    public UserUpdateResponse updateUser(Long id, UserUpdateRequest request) {

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new UserException(NO_FOUND_USER));

        return UserUpdateResponse.from(user.updateUser(request));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getUser(Long id) {

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new UserException(NO_FOUND_USER));

        return UserDto.from(user);

    }

    @Transactional
    @Override
    public UserUpdatePasswordResponse updatePassword(Long id, UserUpdatePasswordRequest request) {

        User user = userRepository.findByIdAndPassword(id, request.getPassword())
                                  .orElseThrow(() -> new UserException(NO_FOUND_USER));

        user.updateUserPassword(request.getNewPassword());

        return UserUpdatePasswordResponse.from(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {

        // 회원이 작성한 게시글이 있으면 삭제가 안됨.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(NO_FOUND_USER));

        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public UserCreateResponse findUser(UserFindDto request) {

        User user = userRepository.findByNameAndPhone(
                request.getUserName(),request.getPhone())
                .orElseThrow(() -> new UserException(NO_FOUND_USER));

        return UserCreateResponse.from(user);
    }

    @Transactional
    @Override
    public void resetUserPassword(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(NO_FOUND_USER));

        String resetPassword = UUID.randomUUID().toString(); // 비밀번호 랜덤
        user.resetUserPassword(bcryptPasswordEncoder.encode(resetPassword)); // 비밀번호 암호화
    }
}
