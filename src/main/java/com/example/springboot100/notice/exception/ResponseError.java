package com.example.springboot100.notice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;


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
                            .field(e.getField()) // 에러 발생 필드이름
                            .message(e.getDefaultMessage()) // 에러시 message
                            .build();
    }

    public static List<ResponseError> of(List<ObjectError> errors) {

        return errors.stream()
                     .map(e -> ResponseError.of((FieldError) e))
                     .collect(Collectors.toList());
    }
}
