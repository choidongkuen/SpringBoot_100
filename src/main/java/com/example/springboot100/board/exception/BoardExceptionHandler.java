package com.example.springboot100.board.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(value = BoardException.class)
    public ResponseEntity<BoardExceptionResponse> boardExceptionHandler(BoardException e) {

        log.error("예외발생");
        return BoardExceptionResponse.toResponseEntity(e);
    }
}
