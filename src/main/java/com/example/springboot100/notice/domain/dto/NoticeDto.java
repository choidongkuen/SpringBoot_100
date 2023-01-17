package com.example.springboot100.notice.domain.dto;


import com.example.springboot100.notice.domain.entity.Notice;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {

    private String title;

    private String content;

    private int likes;

    private int hits;

    public static NoticeDto fromEntity( Notice notice ) {

        return NoticeDto.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .likes(notice.getLikes())
                .hits(notice.getHits())
                .build();
    }
}
