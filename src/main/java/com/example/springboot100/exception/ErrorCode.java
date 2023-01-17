package com.example.springboot100.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    NO_FOUND_NOTICE("해당하는 게시글 정보가 없습니다.", HttpStatus.BAD_REQUEST),

    NO_FOUND_USER("해당하는 사용자 정보가 없습니다.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

}
