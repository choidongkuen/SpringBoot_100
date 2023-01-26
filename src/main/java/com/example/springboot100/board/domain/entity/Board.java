package com.example.springboot100.board.domain.entity;

import com.example.springboot100.board.domain.dto.BoardCreateInputDto;
import com.example.springboot100.notice.domain.entity.BaseEntity;
import com.example.springboot100.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE BOARD SET BOARD.DELETED_AT = CURRENT_TIMESTAMP WHERE BOARD.ID = ?")
@Where(clause = "DELETED_AT is NULL")
@Table
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    private BoardType boardType;

    @Column
    private String title;

    @Column
    @Lob
    private String content;

    public void updateBoard(BoardCreateInputDto request) {

        this.title = request.getBoardName();
        this.content = request.getBoardContent();
    }
}
