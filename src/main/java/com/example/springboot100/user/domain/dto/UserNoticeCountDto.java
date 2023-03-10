package com.example.springboot100.user.domain.dto;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserNoticeCountDto {
    private Long userId;

    private String email;

    private String userName;

    private Long noticeCount;
}
