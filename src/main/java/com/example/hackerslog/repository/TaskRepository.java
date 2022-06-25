package com.example.hackerslog.repository;

import com.example.hackerslog.model.TaskModel;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * タスク情報 Mapper
 */
@Mapper
public interface TaskRepository {
    /**
     * 指定したプロジェクトのタスク情報を取得する
     * @param projectId projectId
     * @return タスク一覧
     */
    @Select("SELECT id, user_id as userId, project_id as projectId, name, status_id as statusId FROM task WHERE project_id = #{projectId}")
    List<TaskModel> findByProjectId(@Param("projectId") Integer projectId);

    @Select("SELECT id, user_id as userId, project_Id as projectId, name, contents, status_id as statusId, created_at as createdAt, updated_at as updatedAt FROM task WHERE id = #{taskId}")
    TaskModel findByTaskId(@Param("taskId") Integer taskId);

    @Insert("INSERT INTO task (user_id, project_id, name, contents, status_id) VALUES (#{userId}, #{projectId}, #{name}, #{contents}, #{statusId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(TaskModel task);

    @Update("UPDATE task set user_id = #{userId}, name = #{name}, contents = #{contents}, status_id = #{statusId}, updated_at = #{updatedAt} WHERE id = #{id}")
    int update(TaskModel task);
}
