package com.example.springboot100.notice.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class NoticeExceptionResponse {

    private final int status;

    private final String error;

    private final String code;

    private final String description;

    private final String message;

    public static ResponseEntity<NoticeExceptionResponse> toResponseEntity(
            NoticeException exception) {

        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(NoticeExceptionResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .error(errorCode.getHttpStatus().name())
                        .code(errorCode.name())
                        .description(errorCode.getMessage())
                        .message(exception.getMessage())
                        .build());
    }
}
