package com.example.springboot100.admin.domain.dto;


import com.example.springboot100.user.domain.dto.UserDto;
import com.example.springboot100.user.domain.entity.User;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

    ResponseMessageHeader responseMessageHeader;

    Object body;

    public static ResponseMessage success(Object data) {

        return ResponseMessage.builder()
                .responseMessageHeader(ResponseMessageHeader.builder()
                        .result(true)
                        .resultCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .message(HttpStatus.OK.getReasonPhrase())
                        .build())
                .body(data)
                .build();
    }

    public static ResponseMessage success() {

        return success(null);
    }

    public static ResponseMessage fail(String message, Object data) {

        return ResponseMessage.builder()
                              .responseMessageHeader(ResponseMessageHeader.builder()
                                      .result(false)
                                      .resultCode(HttpStatus.BAD_REQUEST.value())
                                      .status(HttpStatus.BAD_REQUEST.name())
                                      .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                      .build())
                              .body(data)
                              .build();
    }

    public static ResponseMessage fail(String message) {

        return fail(message, null);
    }
}
