package com.example.springboot100.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    NO_FOUND_NOTICE("해당하는 공지사항 정보가 없습니다.", HttpStatus.BAD_REQUEST),

    NO_FOUND_USER("해당하는 사용자 정보가 없습니다.", HttpStatus.BAD_REQUEST),
    NO_MATCH_PASSWORD("비밀번호가 일치하지 않습니다", HttpStatus.BAD_REQUEST),

    ALREADY_BOARD_EXISTS("해당 공지사항은 이미 존재합니다.", HttpStatus.BAD_REQUEST),

    NO_FOUND_BOARD("해당하는 게시글 정보가 없습니다.", HttpStatus.BAD_REQUEST),

    NO_FOUND_BOARD_TYPE("해당하는 게시글 유형이 없습니다.", HttpStatus.BAD_REQUEST),

    SAME_NAME("변경하려는 게시글 제목이 기존과 동일합니다.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

}
