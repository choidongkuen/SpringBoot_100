package com.example.springboot100.board.service;

import com.example.springboot100.board.domain.dto.BoardCreateInputDto;
import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;
import com.example.springboot100.board.domain.dto.BoardTypeListGetResponseDto;
import com.example.springboot100.board.domain.entity.BoardType;

import java.util.List;

public interface BoardService {

    void addBoardType(BoardTypeInputRequestDto request);

    void updateBoardType(Long id,BoardTypeInputRequestDto request);

    void deleteBoardType(Long id);

    List<BoardTypeListGetResponseDto> getBoardList();
}
