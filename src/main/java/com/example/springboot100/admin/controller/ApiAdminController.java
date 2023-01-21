package com.example.springboot100.admin.controller;

import com.example.springboot100.admin.domain.dto.UserInfoResponseDto;
import com.example.springboot100.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
