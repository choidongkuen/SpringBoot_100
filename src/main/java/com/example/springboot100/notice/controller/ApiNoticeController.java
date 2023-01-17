package com.example.springboot100.notice.controller;


import com.example.springboot100.notice.domain.dto.CreateNoticeDto.CreateNoticeResponse;
import com.example.springboot100.notice.domain.dto.CreateNoticeDto.NoticeInputRequest;
import com.example.springboot100.notice.domain.dto.NoticeDeleteInput;
import com.example.springboot100.notice.domain.dto.NoticeDto;
import com.example.springboot100.notice.exception.ResponseError;
import com.example.springboot100.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ApiNoticeController {
    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public ResponseEntity<Object> addNotice(
            @RequestBody @Valid NoticeInputRequest request
            , Errors errors
    ) {

        if (errors.hasErrors()) {

            List<ResponseError> responseErrors = new ArrayList<>();

            errors.getAllErrors().forEach(e -> {

                responseErrors.add(ResponseError.of((FieldError) e));
            });

            return new ResponseEntity<>(
                    responseErrors, HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(CreateNoticeResponse.fromEntity(
                noticeService.createNotice(request)), HttpStatus.OK
        );
    }

    @GetMapping("/api/notice/{id}")
    public ResponseEntity<NoticeDto> getNotice(@PathVariable("id") Long id) {

        return new ResponseEntity<>(NoticeDto.fromEntity(
                noticeService.getNotice(id)), HttpStatus.OK
        );
    }

    @PutMapping("/api/notice/{id}")
    public ResponseEntity<NoticeDto> updateDto(
            @PathVariable("id") Long id,
            @RequestBody NoticeInputRequest request) {
        return new ResponseEntity<>(NoticeDto.fromEntity(
                noticeService.updateNotice(id, request)), HttpStatus.OK
        );
    }

    @PatchMapping("/api/notice/{id}/hits")
    public ResponseEntity<Object> noticeHits(@PathVariable("id") Long id) {

        noticeService.noticeHits(id);
        return ResponseEntity.ok().build();
    }


    // 하나 삭제
    @DeleteMapping("/api/notice/{id}")
    public ResponseEntity<Object> deleteNotice(@PathVariable("id") Long id) {

        noticeService.deleteNotice(id);
        return ResponseEntity.ok().build();
    }

    // 여러개 삭제
    @DeleteMapping("/api/notice")
    public ResponseEntity<Object> deleteNoticeList(@RequestBody @Valid NoticeDeleteInput request) {

        noticeService.deleteNoticeList(request);
        return ResponseEntity.ok().build();

    }

    // pagination
    @GetMapping("/api/notice/latest/{size}")
    public ResponseEntity<Object> noticeLatest(@PathVariable("size") int size) {

        return new ResponseEntity<>(
                noticeService.noticeLatest(size), HttpStatus.OK);

    }
}
