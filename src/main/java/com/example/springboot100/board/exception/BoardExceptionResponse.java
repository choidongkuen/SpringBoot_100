package com.example.springboot100.board.exception;

import com.example.springboot100.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class BoardExceptionResponse {

    private final int status;

    private final String error;

    private final String code;

    private final String description;

    private final String message;
    public static ResponseEntity<BoardExceptionResponse> toResponseEntity(
            BoardException e
    ) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(BoardExceptionResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .error(errorCode.getHttpStatus().name())
                        .code(errorCode.name())
                        .description(errorCode.getMessage())
                        .message(e.getMessage())
                        .build());

    }
}
