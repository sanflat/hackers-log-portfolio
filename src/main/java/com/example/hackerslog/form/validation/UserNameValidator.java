package com.example.hackerslog.form.validation;

import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ユーザー名カスタムアノテーションのバリデーションクラス
 */
public class UserNameValidator implements ConstraintValidator<UserName, String> {

    @Autowired
    UserService userService;

    public void initialize(UserName constraintAnnotation) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {

        UserModel user = userService.findName(value);
        if(user == null){
            return true;
        }
        return false;
    }
}