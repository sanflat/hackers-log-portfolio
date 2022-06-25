package com.example.hackerslog.repository;

import com.example.hackerslog.model.ProjectModel;
import com.example.hackerslog.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserRepository {

    @Select("SELECT id, name, nick_name FROM user WHERE name LIKE '${query}%' or nick_name LIKE '${query}%'")
    List<UserModel> findSelect2List(@Param("query") String query);

    @Select("SELECT * FROM user WHERE mail = #{mail}")
    UserModel findByMail(@Param("mail") String mail);

    @Select("SELECT * FROM user WHERE name = #{name}")
    UserModel findByName(@Param("name") String name);

    @Select("SELECT * FROM user WHERE id = #{id}")
    UserModel findById(@Param("id") Integer id);

    @Insert("INSERT INTO user (mail, name, nick_name, password) VALUE (#{mail},#{name},#{nickName},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createUser(UserModel user);
}
