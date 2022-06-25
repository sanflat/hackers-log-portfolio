package com.example.hackerslog.form.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ユーザーメールカスタムアノテーションのインターフェースクラス
 */
@Documented
@Constraint(validatedBy = {UserMailValidator.class}) // ここは後に作るバリデーションクラスです。
@Target({FIELD}) // 項目に対してバリデーションをかける場合はFIELDを選びます。
@Retention(RUNTIME)
public @interface UserMail {

    String message() default "すでに登録済みのメールアドレスです"; // エラーメッセージです。アノテーションの引数にmessageを設定していない場合は、この値が出力されています。

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        UserMail[] value(); // インターフェース名[] value()としておいてください
    }
}