package com.example.springboot100.notice.exception;

import com.example.springboot100.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NoticeException extends RuntimeException {

    private ErrorCode errorCode;

    public NoticeException(ErrorCode errorCode) {

        this.errorCode = errorCode;

    }

    public NoticeException(ErrorCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }
}
