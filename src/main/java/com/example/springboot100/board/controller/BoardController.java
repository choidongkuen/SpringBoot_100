package com.example.springboot100.board.controller;

import com.example.springboot100.admin.domain.dto.ResponseMessage;
import com.example.springboot100.board.domain.dto.BoardCreateInputDto;
import com.example.springboot100.board.service.BoardService;
import com.example.springboot100.notice.exception.ResponseError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board/type")
    public ResponseEntity<Object> addBoardType(
            @RequestBody @Valid BoardCreateInputDto request,
            Errors error
    ) {

        if(error.hasErrors()) {
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

    @PatchMapping("/api/board/type/{id}")
    public ResponseEntity<Object> updateBoardType(
            @PathVariable("id") Long id,
            @RequestBody @Valid BoardCreateInputDto request,
            Errors errors
    ) {

        if(errors.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(ResponseMessage.fail("입력값이 정확하지 않습니다.",
                            ResponseError.of(errors.getAllErrors()
                            )
                        )
                    );
        }

        boardService.updateBoardType(id,request);
        return ResponseEntity.ok().build();
    }

}
