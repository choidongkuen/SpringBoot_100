package com.example.springboot100.board.service.impl;

import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;
import com.example.springboot100.board.domain.dto.BoardTypeListGetResponseDto;
import com.example.springboot100.board.domain.entity.Board;
import com.example.springboot100.board.domain.entity.BoardType;
import com.example.springboot100.board.domain.repository.BoardTypeRepository;
import com.example.springboot100.board.exception.BoardException;
import com.example.springboot100.board.service.BoardService;
import com.example.springboot100.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public void updateBoardType(Long id,BoardTypeInputRequestDto request) {

        BoardType boardType = boardTypeRepository.findById(id)
                .orElseThrow(() -> new BoardException(ErrorCode.NO_FOUND_BOARD_TYPE));

        if(boardType.getName().equals(request.getName())) {
            throw new BoardException(ErrorCode.ALREADY_BOARD_EXISTS);
        }

        boardType.updateBoardType(request);
    }

    @Transactional
    @Override
    public void deleteBoardType(Long id) {

        BoardType boardType = boardTypeRepository.findById(id)
                .orElseThrow(()-> new BoardException(ErrorCode.NO_FOUND_BOARD_TYPE));

        if(boardType.getBoards().size() > 0 ) {
            throw new BoardException(ErrorCode.BOARD_TYPE_HAS_BOARDS);
        }

        boardTypeRepository.delete(boardType);
    }

    @Transactional
    @Override
    public List<BoardTypeListGetResponseDto> getBoardList() {

        return boardTypeRepository.findAll()
                .stream().map(BoardTypeListGetResponseDto::of)
                .collect(Collectors.toList());
    }
}

