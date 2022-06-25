package com.example.hackerslog.repository;

import com.example.hackerslog.model.StatusModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ステータス情報 Mapper
 */
@Mapper
public interface StatusRepository {
    /**
     * 指定したプロジェクトのステータス情報を取得する
     * @param projectId projectId
     * @return ステータス一覧
     */
    @Select("SELECT id, project_id as projectId, name FROM status WHERE project_id = #{projectId}")
    List<StatusModel> findByProjectId(@Param("projectId") Integer projectId);

    /**
     * 指定した ステータスID のステータス情報を取得する
     * @param id statusId
     * @return ステータス一覧
     */
    @Select("SELECT id, project_id as projectId, name FROM status WHERE id = #{id}")
    StatusModel findById(@Param("id") Integer id);
}
