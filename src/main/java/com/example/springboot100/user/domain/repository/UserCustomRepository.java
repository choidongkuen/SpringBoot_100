package com.example.springboot100.user.domain.repository;

import com.example.springboot100.user.domain.dto.UserLogDto;
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

    public List<UserLogDto> findUserLogCount() {

        String sql

                = " select u.id, u.email, u.name," +
                " (select count(*) from notice n where n.user_id = u.id) notice_count, " +
                " (select count(*) from notice_like nl where nl.user_id = u.id) notice_like_count " +
                " from user_table u ";

        return entityManager.createNativeQuery(sql).getResultList();

    }

    public List<UserLogDto> findUserLikeBest() {

        String sql = " select t1.id, t1.email, t1.name, t1.notice_like_count "
                + " from ( select u.*, (select count(*) from notice_like nl "
                + " where nl.user_id = u.id ) as notice_like_count from user_table u )t1"
                + " order by t1.notice_like_count desc";

        return entityManager.createNativeQuery(sql).getResultList();

    }
}
