package com.example.springboot100.board.service.impl;

import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;
import com.example.springboot100.board.domain.entity.BoardType;
import com.example.springboot100.board.domain.repository.BoardTypeRepository;
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

    private final BoardTypeRepository boardTypeRepository;

    @Transactional
    @Override
    public void addBoardType(BoardTypeInputRequestDto request) {

        Optional<BoardType> optionalBoardType
                = boardTypeRepository.findByName(request.getName());

        if(optionalBoardType.isPresent()) {
            throw new BoardException(ErrorCode.ALREADY_BOARD_EXISTS);
        }

        boardTypeRepository.save(BoardType.builder()
                                          .name(request.getName())
                                          .build());
    }

}
