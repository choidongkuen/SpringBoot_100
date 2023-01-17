package com.example.springboot100.notice.domain.entity;


import com.example.springboot100.notice.domain.dto.CreateNoticeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@SQLDelete(sql = "UPDATE NOTICE SET NOTICE.DELETED_AT = CURRENT_TIMESTAMP WHERE NOTICE.ID = ?")
@Where(clause = "DELETED_AT is NULL")
@Entity
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int hits;

    @Column
    private int likes;

    public void noticeHits(int i) {

        this.hits = i;
    }

    public Notice updateNotice(CreateNoticeDto.NoticeInputRequest request) {

        this.title = request.getTitle();
        this.content = request.getContent();
        return this;

    }
}
