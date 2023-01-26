package com.example.springboot100.board.controller;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.board.domain.dto.BoardTypeCountResponseDto;
import com.example.springboot100.board.domain.dto.BoardTypeInputRequestDto;
import com.example.springboot100.board.domain.dto.BoardTypeListGetResponseDto;
import com.example.springboot100.board.service.BoardService;
import com.example.springboot100.notice.exception.ResponseError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board/type")
    public ResponseEntity<Object> addBoardType(
            @RequestBody @Valid BoardTypeInputRequestDto request,
            Errors error
    ) {
        if (error.hasErrors()) {
            return ResponseEntity.badRequest()
                                 .body(ResponseMessage.fail("입력값이 정확하지 않습니다.",
                                                 ResponseError.of(error.getAllErrors()
                                                 )
                                         )
                                 );

        }
        boardService.addBoardType(request);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/api/board/type/{id}")
    public ResponseEntity<Object> updateBoardType(
            @PathVariable("id") Long id,
            @RequestBody BoardTypeInputRequestDto request,
            Errors error
    ) {

        if (error.hasErrors()) {
            return ResponseEntity.badRequest()
                                 .body(ResponseMessage.fail("입력값이 정확하지 않습니다.",
                                                 ResponseError.of(error.getAllErrors()
                                                 )
                                         )
                                 );

        }

        boardService.updateBoardType(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/board/type/{id}")
    public ResponseEntity<Object> deleteBoardType(
            @PathVariable("id") Long id
    ) {
        boardService.deleteBoardType(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/board/type")
    public ResponseEntity<List<BoardTypeListGetResponseDto>> getBoardList() {

        return new ResponseEntity<>(boardService.getBoardTypeList(), HttpStatus.OK);

    }


    @GetMapping("/api/board/type/count")
    public ResponseEntity<List<BoardTypeCountResponseDto>> boardTypeCount() {

        return new ResponseEntity<>(boardService.getBoardTypeCount(), HttpStatus.OK);
    }


    @PatchMapping("/api/board/{id}/top")
    public ResponseEntity<Object> boardPostTop(
            @PathVariable("id") Long id
    ) {
        boardService.setBoardTop(id);
        return ResponseEntity.ok().build();
    }
}
