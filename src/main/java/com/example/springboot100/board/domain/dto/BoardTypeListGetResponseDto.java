package com.example.springboot100.board.domain.dto;

import com.example.springboot100.board.domain.entity.BoardType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardTypeListGetResponseDto {

    private String boardTypeName;

    public static BoardTypeListGetResponseDto of(BoardType boardType) {

        return BoardTypeListGetResponseDto.builder()
                                  .boardTypeName(boardType.getName())
                                  .build();
    }
}
