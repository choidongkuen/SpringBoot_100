package com.example.springboot100.noticelike.domain;

import com.example.springboot100.noticelike.domain.entity.NoticeLike;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserNoticeLikeDto {

    private String userName;

    private String userEmail;

    private String title;

    public static UserNoticeLikeDto from(NoticeLike noticeLike) {

        return UserNoticeLikeDto.builder()
                .userName(noticeLike.getUser().getName())
                .userEmail(noticeLike.getUser().getEmail())
                .title(noticeLike.getNotice().getTitle())
                .build();
    }
}
