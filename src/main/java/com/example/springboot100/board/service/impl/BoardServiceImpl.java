package com.example.springboot100.board.service.impl;

import com.example.springboot100.board.domain.dto.BoardCreateInputDto;
import com.example.springboot100.board.domain.entity.Board;
import com.example.springboot100.board.domain.repository.BoardRepository;
import com.example.springboot100.board.exception.BoardException;
import com.example.springboot100.board.service.BoardService;
import com.example.springboot100.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Override
    public void addBoardType(BoardCreateInputDto request) {

        if(boardRepository.findByName(request.getBoardName()).isPresent()) {

            throw new BoardException(ErrorCode.ALREADY_BOARD_EXISTS);

        }

        boardRepository.save(Board.builder()
                .name(request.getBoardName())
                .content(request.getBoardContent())
                .build());
    }
}
