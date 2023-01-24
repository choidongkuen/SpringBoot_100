package com.example.springboot100.user.domain.repository;

import com.example.springboot100.user.domain.dto.UserNoticeCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserCustomRepository {

    private final EntityManager entityManager;

    public List<UserNoticeCountDto> findUserNoticeCount() {

        String sql
                = "select u.id, u.email, u.name,(select count(*) from Notice n where n.user_id = u.id) notice_count from USER_TABLE u ";

        // 항상 테이블 이름 기준
        List<UserNoticeCountDto> result =  entityManager.createNativeQuery(sql).getResultList();
        return result;

    }
}
