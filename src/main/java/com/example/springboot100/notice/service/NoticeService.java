package com.example.springboot100.notice.service;

import com.example.springboot100.notice.domain.dto.CreateNoticeDto;
import com.example.springboot100.notice.domain.dto.NoticeDeleteInput;
import com.example.springboot100.notice.domain.dto.NoticeDto;
import com.example.springboot100.notice.domain.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoticeService {
    Notice createNotice(CreateNoticeDto.NoticeInputRequest request);

    Notice getNotice(Long id);

    Notice updateNotice(Long id, CreateNoticeDto.NoticeInputRequest request);

    void noticeHits(Long id);

    void deleteNotice(Long id);
    void deleteNoticeList(NoticeDeleteInput request);

    Page<Notice> noticeLatest(int count);
}
