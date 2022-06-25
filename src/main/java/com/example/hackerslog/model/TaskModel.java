package com.example.hackerslog.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskModel {
    private Integer id;
    private Integer userId;
    private Integer projectId;
    private String name;
    private String contents;
    private Integer statusId;
    private Date createdAt;
    private Date updatedAt;
}
