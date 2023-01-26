package com.example.springboot100.board.domain.dto;


import jdk.jfr.Timespan;
import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardTypeCountResponseDto {

    private Long id;

    private String name;

    private LocalDateTime regDt;

    private Long boardCount;

    public BoardTypeCountResponseDto(BigInteger id, String name,
                                     Timestamp createdDt, BigInteger boardCount) {

        this.id = id.longValue();
        this.name = name;
        this.regDt = createdDt.toLocalDateTime();
        this.boardCount = boardCount.longValue();
    }

}
