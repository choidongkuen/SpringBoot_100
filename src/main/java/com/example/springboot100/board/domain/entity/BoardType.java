package com.example.springboot100.board.domain.entity;

import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;
import com.example.springboot100.notice.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class BoardType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "boardType")
    private List<Board> boards = new ArrayList<>();

    public void updateBoardType(BoardTypeInputRequestDto request) {
        this.name = request.getName();
    }
}
