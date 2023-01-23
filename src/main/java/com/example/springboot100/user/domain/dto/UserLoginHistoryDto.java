package com.example.springboot100.user.domain.dto;

import com.example.springboot100.user.domain.entity.User;
import com.example.springboot100.user.domain.entity.UserLoginHistory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginHistoryDto {

    private String userName;

    private String email;

    private LocalDateTime loginDt;

    private String ipAddr;

    public static UserLoginHistoryDto from(UserLoginHistory userLoginHistory) {

        return UserLoginHistoryDto.builder()
                .userName(userLoginHistory.getUser().getName())
                .email(userLoginHistory.getUser().getEmail())
                .loginDt(userLoginHistory.getLoginDt())
                .ipAddr(userLoginHistory.getIpAddress())
                .build();
    }
}
