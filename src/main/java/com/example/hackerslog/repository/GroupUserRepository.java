package com.example.hackerslog.repository;

import com.example.hackerslog.model.GroupUserModel;
import com.example.hackerslog.model.ProjectModel;
import com.example.hackerslog.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * グループユーザー情報 Mapper
 */
@Mapper
public interface GroupUserRepository {

    @Insert("INSERT INTO group_user (id,user_id) VALUE (#{id},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createGroupUser(GroupUserModel groupUserModel);

    @Select("SELECT max(id) FROM group_user")
    int findByMaxId();
}
