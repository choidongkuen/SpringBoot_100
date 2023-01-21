package com.example.springboot100.admin.domain.dto;

import com.example.springboot100.user.domain.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponseDto {

    private List<UserDto> userList;

    private Long totalUserCount;

}
