package com.example.springboot100.board.domain.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardTypeInputRequestDto {

    @NotBlank(message = "게시판 타입 제목은 필수 입력값입니다.")
    private String name;
}
