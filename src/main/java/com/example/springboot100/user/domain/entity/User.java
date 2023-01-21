package com.example.springboot100.user.domain.entity;


import com.example.springboot100.notice.domain.entity.BaseEntity;
import com.example.springboot100.user.domain.dto.UserUpdateDto.UserUpdateRequest;
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
@Table(name = "USER_TABLE")
@SQLDelete(sql = "UPDATE USER_TABLE SET USER_TABLE.DELETED_AT = CURRENT_TIMESTAMP WHERE USER_TABLE.ID = ?")
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

    public User updateUser(UserUpdateRequest request) {

        this.phone = request.getPhone();
        this.name = request.getName();
        return this;

    }

    public void updateUserPassword (String newPassword) {

        this.password = newPassword;
    }

}
