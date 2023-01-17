package com.example.springboot100.notice.domain.dto;


import com.example.springboot100.notice.domain.entity.Notice;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CreateNoticeDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class NoticeInputRequest {

        @Size(min = 10, max = 100, message = "제목은 10 - 100자 사이의 값입니다.")
        @NotBlank(message = "제목은 필수 항목입니다.")
        private String title;


        @Size(min = 50, max = 1000, message = "제목은 10 - 100자 사이의 값입니다.")
        @NotBlank(message = "내용은 필수 항목입니다.")
        private String content;

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class CreateNoticeResponse {

        private String title;
        public static CreateNoticeResponse fromEntity(Notice notice) {

            return CreateNoticeResponse.builder()
                    .title(notice.getTitle())
                    .build();
        }
    }
}
