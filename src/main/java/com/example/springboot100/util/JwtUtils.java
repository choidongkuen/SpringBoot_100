package com.example.springboot100.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@AllArgsConstructor
public class JwtUtils {
    private String key = "Z-TOKEN";

    public String getIssuer(String token) {

        return JWT.require(Algorithm.HMAC512(key.getBytes()))
                  .build()
                  .verify(token)
                  .getIssuer();
    }
}
