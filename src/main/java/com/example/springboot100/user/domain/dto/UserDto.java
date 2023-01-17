package com.example.springboot100.user.domain.dto;


import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String email;

    private String name;

    private String phone;
}
