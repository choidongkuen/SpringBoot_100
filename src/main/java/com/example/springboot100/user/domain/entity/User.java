package com.example.springboot100.user.domain.entity;


import com.example.springboot100.notice.domain.entity.BaseEntity;
import com.example.springboot100.user.domain.dto.UserUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@SQLDelete(sql = "UPDATE USER SET USER.DELETED_AT = CURRENT_TIMESTAMP WHERE USER.ID = ?")
@Where(clause = "DELETED_AT is NULL")
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    public User updateUser(UserUpdateDto.UserUpdateRequest request) {

        this.phone = request.getPhone();
        this.name = request.getName();
        return this;

    }
}
