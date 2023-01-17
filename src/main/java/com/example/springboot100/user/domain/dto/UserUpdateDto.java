package com.example.springboot100.user.domain.dto;

import com.example.springboot100.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdateDto {


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class UserUpdateRequest {

        @NotBlank
        @Size(max = 20, message = "연락처는 최대 20자까지 입력 가능합니다.")
        private String phone;


        @NotBlank(message = "이름은 필수 항목 입니다.")
        private String name;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class UserUpdateResponse {


        private String phone;

        private String name;

        public static UserUpdateResponse from(User user) {

            return UserUpdateResponse.builder()
                    .phone(user.getPhone())
                    .name(user.getName())
                    .build();
        } // Test 필요
    }
}
