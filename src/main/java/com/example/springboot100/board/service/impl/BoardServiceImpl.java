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
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
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

    @Transactional
    @Override
    public void updateBoardType(Long id, BoardCreateInputDto request) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardException(ErrorCode.NO_FOUND_NOTICE));

        if(board.getName().equals(request.getBoardName())) {
            throw new BoardException(ErrorCode.SAME_NAME);
        }

        board.updateBoard(request);
    }
    @Transactional
    @Override
    public void deleteBoardType(Long id) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardException(ErrorCode.NO_FOUND_BOARD));

        boardRepository.delete(board);

    }
}
