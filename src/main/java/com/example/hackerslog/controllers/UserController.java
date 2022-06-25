package com.example.hackerslog.controllers;

import com.example.hackerslog.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.hackerslog.service.UserService;
import com.example.hackerslog.common.UserAuthClass;

/**
 * ユーザー Controller
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * サインイン画面を表示
     * @param model
     * @return user/sign_in
     */
    @GetMapping(value = "/sign_in")
    public String signIn(Model model) {
        UserAuthClass userAuthClass = new UserAuthClass();
        userAuthClass.getAuthModelAttribute(model);
        model.addAttribute("isSignUp",true);
        return "user/sign_in";
    }

    /**
     * サインアップ画面を表示
     * @param userForm, model
     * @return user/sign_up
     */
    @GetMapping(value = "/sign_up")
    public String signUp(@ModelAttribute UserForm userForm, Model model) {
        UserAuthClass userAuthClass = new UserAuthClass();
        userAuthClass.getAuthModelAttribute(model);
        model.addAttribute("userForm",userForm);
        return "user/sign_up";
    }

    /**
     * アカウント登録処理
     * @param userForm
     * @return バリデーションエラー/アカウント完了を知らせるモーダルに用いる値を返却
     */
    @PostMapping(value = "/sign_up/create")
    public String userCreate(@ModelAttribute @Validated UserForm userForm, BindingResult result, Model model){
        if (result.hasErrors()){
            return signUp(userForm,model);
        }
        // userService.createUser(userForm);
        // ユーザー登録成功時のモーダル表示に使用するデータを追加
        model.addAttribute("createResult",true);
        return signIn(model);
    }
}