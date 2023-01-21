package com.example.springboot100.user.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserFindDto {

    @NotBlank(message = "이름은 필수 항목입니다.")
    private String userName;

    @NotBlank(message = "전화번호는 필수 항목입니다.")
    @Size(message = "전화번호는 최대 20자 입니다.")
    private String phone;

}
