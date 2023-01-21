package com.example.springboot100.user.domain.dto;


import com.example.springboot100.user.domain.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserCreateDto {


    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserCreateRequest {

        @Email(message = "이메일 형식에 맞게 입력해 주세요.")
        @NotBlank(message = "이메일은 필수 항목 입니다.")
        private String email;

        @NotBlank(message = "이름은 필수 항목 입니다.")
        private String name;

        @NotBlank(message = "비밀번호는 필수 항목 입니다.")
        @Size(min = 4, message = "비밀번호는 4자 이상 입력해야 합니다.")
        private String password;

        @NotBlank(message = "전화번호는 필수 항목 입니다.")
        @Size(max = 20 ,message = "전화번호는 최대 20자 입니다.")
        private String phone;
    }


    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserCreateResponse {

        private String email;

        private String name;


        public static UserCreateResponse from(User user) {

            return UserCreateResponse.builder()
                    .email(user.getEmail())
                    .name(user.getName())
                    .build();
        }
    }
}
