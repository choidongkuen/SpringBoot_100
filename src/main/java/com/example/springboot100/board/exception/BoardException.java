package com.example.springboot100.board.exception;

import com.example.springboot100.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class BoardException extends RuntimeException {

    private ErrorCode errorCode;

    public BoardException(ErrorCode errorCode) {

        this.errorCode = errorCode;

    }

    public BoardException(ErrorCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }
}
