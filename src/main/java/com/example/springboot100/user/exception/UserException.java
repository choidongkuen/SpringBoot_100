package com.example.springboot100.user.exception;

import com.example.springboot100.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserException extends RuntimeException {

    private ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {

        this.errorCode = errorCode;

    }

    public UserException(ErrorCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }
}
