package com.example.springboot100.board.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardCreateInputDto {

    @NotBlank(message = "게시판 제목은 필수 입력값입니다.")
    @Size(max = 50, message = "게시판 제목은 최대 50자 입니다.")
    private String boardName;

    @NotEmpty(message = "게시판 내용은 필수 입력값입니다.")
    @Size(max = 500, message = "게시판 내용은 최대 500자 입니다.")
    private String boardContent;

}
