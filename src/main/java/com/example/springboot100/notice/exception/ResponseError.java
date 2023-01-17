package com.example.springboot100.notice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;


@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private String error;

    private int code;

    private String field;

    private String message;


    public static ResponseError of(FieldError e) {

        return ResponseError.builder()
                            .error(HttpStatus.BAD_REQUEST.name())
                            .code(HttpStatus.BAD_REQUEST.value())
                            .field(e.getField())
                            .message(e.getDefaultMessage())
                            .build();
    }

}
