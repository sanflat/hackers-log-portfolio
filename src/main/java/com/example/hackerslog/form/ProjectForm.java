package com.example.hackerslog.form;

import lombok.Data;

/**
 * プロジェクト情報 Formデータ
 */
@Data
public class ProjectForm {
    private Integer id;
    private Integer group_user_id;
    private String name;
}