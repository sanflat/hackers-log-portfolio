package com.example.hackerslog.model;

import lombok.Data;

@Data
public class UserModel {
    private Integer id;
    private String mail;
    private String name;
    private String nickName;
    private String password;
}
