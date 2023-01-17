package com.example.springboot100.notice.service.impl;


import com.example.springboot100.notice.domain.dto.CreateNoticeDto.NoticeInputRequest;
import com.example.springboot100.notice.domain.dto.NoticeDeleteInput;
import com.example.springboot100.notice.domain.entity.Notice;
import com.example.springboot100.notice.domain.repository.NoticeRepository;
import com.example.springboot100.notice.exception.NoticeException;
import com.example.springboot100.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.springboot100.exception.ErrorCode.NO_FOUND_NOTICE;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    @Override
    public Notice createNotice(NoticeInputRequest request) {


        return noticeRepository.save(Notice.builder()
                                           .title(request.getTitle())
                                           .content(request.getContent())
                                           .build()
        );
    }

    @Override
    public Notice getNotice(Long id) {

        return noticeRepository.findById(id)
                               .orElseThrow(() -> new NoticeException(NO_FOUND_NOTICE)
                               );
    }

    @Transactional
    @Override
    public Notice updateNotice(Long id, NoticeInputRequest request) {

        Notice notice = noticeRepository.findById(id)
                                        .orElseThrow(() -> new NoticeException(NO_FOUND_NOTICE));

        return notice.updateNotice(request);
    }


    @Transactional
    @Override
    public void noticeHits(Long id) {

        Notice notice = noticeRepository.findById(id)
                                        .orElseThrow(() -> new NoticeException(NO_FOUND_NOTICE));

        notice.noticeHits(notice.getHits() + 1);
    }

    @Transactional
    @Override
    public void deleteNotice(Long id) {

        Notice notice = noticeRepository.findById(id)
                                        .orElseThrow(() -> new NoticeException(NO_FOUND_NOTICE));

        noticeRepository.delete(notice);
    }

    @Transactional
    @Override
    public void deleteNoticeList(NoticeDeleteInput request) {


        List<Notice> noticeList = noticeRepository.findByIdIn(request.getIdList())
                                                  .orElseThrow(() -> new NoticeException(NO_FOUND_NOTICE));

        noticeRepository.deleteAll(noticeList);

    }

    @Override
    public Page<Notice> noticeLatest(int size) {

        return noticeRepository.findAll(
                PageRequest.of(0, size, Sort.Direction.DESC, "id")
        );
    }
}
