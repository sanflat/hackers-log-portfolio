package com.example.hackerslog.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectModel {
    private Integer id;
    private Integer groupUserId;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
