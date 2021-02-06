package com.ximen.validation.annotation;

import com.ximen.validation.validator.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
    String message() default "错误默认提示信息";

    int max()  default 100;

    int min()  default 80;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
