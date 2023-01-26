package com.example.springboot100.board.service;

import com.example.springboot100.board.domain.dto.BoardTypeCountResponseDto;
import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;
import com.example.springboot100.board.domain.dto.BoardTypeListGetResponseDto;

import java.util.List;

public interface BoardService {

    void addBoardType(BoardTypeInputRequestDto request);

    void updateBoardType(Long id,BoardTypeInputRequestDto request);

    void deleteBoardType(Long id);

    List<BoardTypeListGetResponseDto> getBoardTypeList();

    List<BoardTypeCountResponseDto> getBoardTypeCount();

    void setBoardTop(Long id);
}
