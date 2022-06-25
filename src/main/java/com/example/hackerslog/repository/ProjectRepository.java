package com.example.hackerslog.repository;

import com.example.hackerslog.model.ProjectModel;
import com.example.hackerslog.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * プロジェクト情報 Mapper
 */
@Mapper
public interface ProjectRepository {

    @Select("SELECT * FROM project WHERE id = #{id}")
    ProjectModel findById(@Param("id") Integer id);

    @Select("SELECT * FROM project INNER JOIN group_user ON project.group_user_id = group_user.id WHERE user_id = #{userId}")
    List<ProjectModel> findByProjectList(@Param("userId") Integer userId);

    @Insert("INSERT INTO project (group_user_id, name) VALUE (#{groupUserId},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createProject(ProjectModel project);
}
