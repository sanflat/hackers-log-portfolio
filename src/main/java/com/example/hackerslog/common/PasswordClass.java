package com.example.hackerslog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BCryptPasswordEncoderクラスを利用した
 * パスワードに関する処理を記述するクラス
 */
public class PasswordClass {

    public String encode(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(password);
        return encodePassword;
    }

}
