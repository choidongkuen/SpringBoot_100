package com.example.springboot100.user.controller;


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.springboot100.notice.exception.ResponseError;
import com.example.springboot100.user.domain.dto.UserCreateDto.UserCreateRequest;
import com.example.springboot100.user.domain.dto.UserFindDto;
import com.example.springboot100.user.domain.dto.UserLoginDto;
import com.example.springboot100.user.domain.dto.UserUpdateDto;
import com.example.springboot100.user.domain.dto.UserUpdatePasswordDto;
import com.example.springboot100.user.domain.dto.UserUpdatePasswordDto.UserUpdatePasswordRequest;
import com.example.springboot100.user.domain.dto.UserUpdatePasswordDto.UserUpdatePasswordResponse;
import com.example.springboot100.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApiUserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<Object> addUser(

            @RequestBody @Valid UserCreateRequest request,
            Errors errors)
    {
        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);
        if (responseErrors != null) return responseErrors;

        return new ResponseEntity<>(
                userService.addUser(request),HttpStatus.OK
        );
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<Object> updateUser(
            @PathVariable("id") Long id,
            @RequestBody @Valid UserUpdateDto.UserUpdateRequest request,
            Errors errors
    ) {

        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);
        if (responseErrors != null) return responseErrors;

        return new ResponseEntity<>(
                userService.updateUser(id, request),HttpStatus.OK
        );
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {

        return new ResponseEntity<>(
                userService.getUser(id), HttpStatus.OK
        );
    }

    @PatchMapping("/api/user/{id}/password")
    public ResponseEntity<Object> updateUserPassword(
            @PathVariable Long id,
            @RequestBody @Valid UserUpdatePasswordRequest request,
            Errors errors
    ) {

        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);

        if (responseErrors != null){
            return responseErrors;
        }

        return new ResponseEntity<>(
                userService.updatePassword(id, request), HttpStatus.OK
        );

    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Object> deleteUser(
            @PathVariable("id") Long id
    ) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/user")
    public ResponseEntity<Object> findUser(
            @RequestBody UserFindDto request,
            Errors errors

    ) {
        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);

        if (responseErrors != null){
            return responseErrors;
        }

        return new ResponseEntity<>(
                userService.findUser(request), HttpStatus.OK
        );
    }

    @GetMapping("/api/user/{id}/password/reset")
    public ResponseEntity<Object> resetUserPassword(
                    @PathVariable("id") Long id
    ) {
        userService.resetUserPassword(id);
        return ResponseEntity.ok().build();
    }

    // id 해당하는 회원이 좋아요한 게시글 목록
    @GetMapping("/api/user/{id}/notice/like")
    public ResponseEntity<Object> likeNotice(
                  @PathVariable("id") Long id
    ) {

        return new ResponseEntity<> (
                userService.likeNotice(id), HttpStatus.OK
        );
    }

    @PostMapping("/api/user/login")
    public ResponseEntity<Object> createToken(
            @RequestBody @Valid UserLoginDto request,
            Errors errors
    ) {

        ResponseEntity<Object> responseErrors = getObjectResponseEntity(errors);

        if (responseErrors != null){
            return responseErrors;
        }

        return new ResponseEntity<>(
                userService.createToken(request), HttpStatus.OK
        );
    }

    @PatchMapping("/api/user/login")
    public ResponseEntity<Object> refreshToken(@RequestHeader("Z-TOKEN") String token) {

        try {
            return new ResponseEntity<>(
                    userService.refreshToken(token), HttpStatus.OK
            );
        }catch (JWTDecodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public static ResponseEntity<Object> getObjectResponseEntity(Errors errors) {

        if(errors.hasErrors()) {

            List<ResponseError> responseErrors = new ArrayList<>();

            errors.getAllErrors().forEach(e -> {

                responseErrors.add(ResponseError.of((FieldError) e));

            });

            return new ResponseEntity<>(
                    responseErrors, HttpStatus.BAD_REQUEST
            );

        }
        return null;
    }
}
