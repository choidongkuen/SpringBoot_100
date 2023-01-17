package com.example.springboot100.user.exception;

import org.springframework.http.ResponseEntity;

public class UserException extends RuntimeException{
    public static ResponseEntity<UserExceptionResponse> toResponseEntity(UserException e) {
    }
}
