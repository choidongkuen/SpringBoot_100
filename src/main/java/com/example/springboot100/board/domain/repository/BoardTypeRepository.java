package com.example.springboot100.board.domain.repository;

import com.example.springboot100.board.domain.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardTypeRepository extends JpaRepository<BoardType, Long> {

    Optional<BoardType> findByName(String name);
}
