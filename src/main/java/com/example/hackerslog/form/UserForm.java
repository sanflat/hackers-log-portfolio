package com.example.hackerslog.form;

import com.example.hackerslog.form.validation.UserMail;
import com.example.hackerslog.form.validation.UserName;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * ユーザー情報 Formデータ
 */
@Data
public class UserForm{

    private Integer id;
    private String nickName;

    // @UserMail
    @NotBlank(message = "必須の入力項目です")
    @Size(max = 250, message = "250文字以内で入力してください")
    @Email(message = "メールアドレス形式で入力してください")
    private String mail;

    // @UserName
    @NotBlank(message = "必須の入力項目です")
    @Size(max = 20, message = "20文字以内で入力してください")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "半角英数字で入力してください")
    private String name;

    @NotBlank(message = "必須の入力項目です")
    @Pattern(regexp = "^[a-zA-Z0-9!-/:-@¥[-`{-~]]+$", message = "半角英数字記号で入力してください")
    private String password;

}