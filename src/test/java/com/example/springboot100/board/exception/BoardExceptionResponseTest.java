package com.example.springboot100.board.exception;

import com.example.springboot100.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
class BoardExceptionResponseTest {

    @Test
    @DisplayName("BoardExceptionResponse 테스트")
    void boardExceptionResponseTest(){
        // given

        ErrorCode errorCode = ErrorCode.ALREADY_BOARD_EXISTS;
        System.out.println(errorCode.getMessage());
        System.out.println(HttpStatus.OK.name());
        System.out.println(HttpStatus.BAD_REQUEST.name());
        System.out.println(errorCode.name());
        System.out.println(new BoardException(ErrorCode.ALREADY_BOARD_EXISTS).getMessage());
        // when
        // then
     }
  
}