package com.example.springboot100.board.service;

import com.example.springboot100.board.domain.dto.BoardCreateInputDto;
import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;

public interface BoardService {

    void addBoardType(BoardTypeInputRequestDto request);

    void updateBoardType(Long id,BoardTypeInputRequestDto request);

    void deleteBoardType(Long id);
}
