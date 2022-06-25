package com.example.hackerslog.form.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ユーザー名カスタムアノテーションのインターフェースクラス
 */
@Documented
@Constraint(validatedBy = {UserNameValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UserName {

    String message() default "すでに登録済みのユーザー名です";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        UserName[] value();
    }
}