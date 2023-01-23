package com.example.springboot100.admin.controller;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.admin.service.AdminService;
import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.dto.UserLoginHistoryDto;
import com.example.springboot100.user.domain.dto.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApiAdminController {
    private final AdminService adminService;

    @GetMapping("/api/admin/user")
    public ResponseEntity<UserInfoResponseDto> getUserInfo(

    ) {
        return new ResponseEntity<>(
                adminService.getUserInfo(), HttpStatus.OK
        );
    }

    @GetMapping("/api/admin/user/{id}")
    public ResponseEntity<Object> getUserDetail(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(
                adminService.getUserDetail(id), HttpStatus.OK
        );
    }

    // 입력한 일부 이메일을 포함하는 모든 사용자 리스트 조회 API
    @GetMapping("/api/admin/user/search")
    public ResponseEntity<List<UserDto>> findUser(
            @RequestParam(value = "email", required = true) String email
    ) {
        return new ResponseEntity<>(
                adminService.findUser(email), HttpStatus.OK
        );
    }

    // 사용자의 상태를 변경하는 API
    @PatchMapping("/api/admin/{id}/status")
    public ResponseEntity<ResponseMessage> userStatus(
            @PathVariable("id") Long id,
            @RequestBody UserStatus userStatus
    ) {
        return new ResponseEntity<>(
                adminService.userStatus(id, userStatus), HttpStatus.OK
        );
    }

    // 사용자 삭제하는 API
    @DeleteMapping("/api/admin/{id}")
    public ResponseEntity<ResponseMessage> deleteUser(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<> (
                adminService.deleteUser(id), HttpStatus.OK
        );
    }

    // 사용자 잡속 이력 확인하는 API
    @GetMapping("/api/admin/user/{id}/history")
    public ResponseEntity<List<UserLoginHistoryDto>> userLoginHistory(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(
                adminService.userLoginHistory(id), HttpStatus.OK
        );
    }
}
