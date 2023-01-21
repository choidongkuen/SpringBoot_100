package com.example.springboot100.admin.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessageHeader {

    private boolean result;

    private int resultCode;

    private String status;

    private String message;


}
