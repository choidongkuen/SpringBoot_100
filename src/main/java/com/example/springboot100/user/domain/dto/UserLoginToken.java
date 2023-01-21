package com.example.springboot100.user.domain.dto;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginToken {

    private String token;
}
