package com.example.springboot100.notice.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class NoticeExceptionHandler {


    @ExceptionHandler(value = NoticeException.class)
    public ResponseEntity<NoticeExceptionResponse> noticeExceptionHandler(NoticeException e) {

        log.error("예외발생");
        return NoticeExceptionResponse.toResponseEntity(e);
    }
}
