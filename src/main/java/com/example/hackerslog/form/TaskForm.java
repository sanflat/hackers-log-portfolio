package com.example.hackerslog.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * タスク情報 Formデータ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskForm {
    private Integer taskId;
    private String taskName;
    private String contents;
    private Integer userId;
    private String userName;
    private Integer statusId;
    private String statusName;
    private String createdAt;
    private String updatedAt;
}
