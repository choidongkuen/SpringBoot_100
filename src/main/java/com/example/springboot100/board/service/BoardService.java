package com.example.springboot100.board.service;

import com.example.springboot100.board.domain.dto.BoardCreateInputDto;

public interface BoardService {
    void addBoardType(BoardCreateInputDto request);

    void updateBoardType(Long id,BoardCreateInputDto request);

    void deleteBoardType(Long id);
}
