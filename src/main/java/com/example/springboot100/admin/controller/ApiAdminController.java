package com.example.springboot100.admin.controller;

import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.admin.service.AdminService;
import com.example.springboot100.user.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springboot100.user.controller.ApiUserController.getObjectResponseEntity;

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
            @RequestParam(value = "email" ,required = true) String email
    ) {
        return new ResponseEntity<>(
                adminService.findUser(email), HttpStatus.OK
        );
    }
}
