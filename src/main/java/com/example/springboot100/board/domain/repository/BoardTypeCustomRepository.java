package com.example.springboot100.board.domain.repository;

import com.example.springboot100.board.domain.dto.BoardTypeCountResponseDto;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardTypeCustomRepository {

    private final EntityManager em;

    // native 쿼리는 json 으로 매핑 안되는 경우 존재
    public List<BoardTypeCountResponseDto> getBoardTypeCount() {

        String sql = " SELECT bt.id, bt.name, bt.created_at, " +
                "(SELECT count(*) FROM board b WHERE b.board_type_id = bt.id ) as board_count " +
                " FROM board_type bt";

        // qlrm 라이브러리 사용
        Query nativeQuery = em.createNativeQuery(sql);
        JpaResultMapper mapper = new JpaResultMapper();
        return mapper.list(nativeQuery, BoardTypeCountResponseDto.class);
    }
}
