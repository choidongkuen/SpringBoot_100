package com.example.springboot100.noticelike.domain.entity;

import com.example.springboot100.notice.domain.entity.Notice;
import com.example.springboot100.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class NoticeLike { // 회원과 게시판 사이의 좋아요 관련 다대다 관계를 해결하기 위한 엔티티

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    @ManyToOne
    @JoinColumn(name = "noticeId")
    private Notice notice;

}
