package com.example.hackerslog.form.validation;

import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ユーザーメールカスタムアノテーションのバリデーションクラス
 */
public class UserMailValidator implements ConstraintValidator<UserMail, String> {

    @Autowired
    UserService userService; // ここは各自の設定に合わせてください。

    public void initialize(UserMail constraintAnnotation) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {

        UserModel user = userService.findMail(value); // ここのvalueは入力値になります
        if(user == null){
            return true;
        }
        return false;
    }
}