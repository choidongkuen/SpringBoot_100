package com.example.springboot100.board.domain.repository;

import com.example.springboot100.board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
