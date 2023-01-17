package com.example.springboot100.notice.domain.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDeleteInput {

    @NotBlank
    private List<Long> idList;

}
