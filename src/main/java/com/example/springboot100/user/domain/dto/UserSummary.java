package com.example.springboot100.user.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserSummary {

    private Long stopUserCount;

    private Long usingUserCount;

    private Long totalUserCount;

    public static UserSummary of(Long stopUsercount,
                                 Long usingUserCount,Long totalUserCount) {
        return UserSummary.builder()
                .stopUserCount(stopUsercount)
                .usingUserCount(usingUserCount)
                .totalUserCount(totalUserCount)
                .build();
    }

} // 사용자 통계 응답 관련 dto
