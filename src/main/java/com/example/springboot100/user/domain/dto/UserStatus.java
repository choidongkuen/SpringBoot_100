package com.example.springboot100.user.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public enum UserStatus {

    NONE, USING, STOP;


    @JsonCreator // 역직력화(JSON -> 객체)
    public static UserStatus from(@JsonProperty("status") String value) {

        return UserStatus.valueOf(value.toUpperCase());

    }
}
