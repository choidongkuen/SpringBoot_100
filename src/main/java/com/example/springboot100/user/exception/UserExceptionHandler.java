package com.example.springboot100.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<UserExceptionResponse> userExceptionHandler(UserException e) {

        log.error("예외발샹");
        return UserException.toResponseEntity(e);
    }
}
