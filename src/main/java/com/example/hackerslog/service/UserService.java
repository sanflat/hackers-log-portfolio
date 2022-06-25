package com.example.hackerslog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hackerslog.form.UserForm;
import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザー情報のselect2の検索＆取得
     * @param  query
     * @return mail情報から取得したUserデータ
     */
    public List<UserModel> findSelect2List(String query) {
        return userRepository.findSelect2List(query);
    }

    /**
     * ユーザー情報のメールアドレスデータ検索＆取得
     * @param  mail
     * @return mail情報から取得したUserデータ
     */
    public UserModel findMail(String mail) {
        return userRepository.findByMail(mail);
    }

    /**
     * ユーザー情報の名前データ検索＆取得
     * @param  name
     * @return name情報から取得したUserデータ
     */
    public UserModel findName(String name) {
        return userRepository.findByName(name);
    }

    /**
     * ユーザー情報のDB登録
     * @param  userForm
     */
    public void createUser(UserForm userForm) {
        UserModel user = new UserModel();
        user.setMail(userForm.getMail());
        user.setName(userForm.getName());
        // 登録時はユーザー名をニックネームする
        // ニックネームがある事で重複した名前を設定できる
        user.setNickName(userForm.getName());
        user.setPassword(userForm.getPassword());
        userRepository.createUser(user);
    }
}