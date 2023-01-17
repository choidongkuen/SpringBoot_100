package com.example.springboot100.user.domain.dto;


import com.example.springboot100.user.domain.entity.User;
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

    public static UserDto from(User user) {

        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .phone(user.getPhone())
                .build();
    }
}
