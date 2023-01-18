package com.example.springboot100.user.exception;

import com.example.springboot100.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class UserExceptionResponse {

    private final int status;


    private final String error;

    private final String code;

    private final String description;

    private final String message;


    public static ResponseEntity<UserExceptionResponse> toResponseEntity(
            UserException e
    ) {

        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(UserExceptionResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .error(errorCode.getHttpStatus().name())
                        .code(errorCode.name())
                        .description(errorCode.getMessage())
                        .message(e.getMessage())
                        .build());
    }
}
