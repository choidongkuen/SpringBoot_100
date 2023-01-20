package com.example.springboot100.user.domain.dto;

import com.example.springboot100.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdatePasswordDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserUpdatePasswordRequest {

        @NotBlank(message = "현재 비밀번호는 필수 항목입니다.")
        private String password;

        @Size(min = 4, max = 20, message = "신규 비밀번호는 4 - 20 사이의 길이로 입력해주세요")
        @NotBlank(message = "신규 비밀번호는 필수 항목입니다.")
        private String newPassword;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserUpdatePasswordResponse {

        private Long userId;

        private String name;

        private String email;

        public static UserUpdatePasswordResponse from(User user) {

            return UserUpdatePasswordResponse.builder()
                    .userId(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();

        }

    }
}
