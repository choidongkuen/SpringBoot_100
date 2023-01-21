package com.example.springboot100.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    // password : 로그인시 입력받음 password
    // encryptedPassword : DB 에서 가져온 암호화된 password
    public static boolean equalPassword(String password, String encryptedPassword){
        return BCrypt.checkpw(password,encryptedPassword);
    }
}
