package com.ximen.validation.validator;

import com.ximen.validation.annotation.Age;

import javax.validation.ClockProvider;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Target;

/**
 * @author zhishun.cai
 * @date 2021/2/4 10:20
 */

public class AgeValidator implements ConstraintValidator<Age, String> {

    private Integer max;

    private Integer min;

    /**
     * 技巧1：必须实现ConstraintValidator接口
     * 技巧2：实现了ConstraintValidator接口后即使不进行Bean配置，spring也会将这个类进行Bean管理
     * 技巧3：可以在实现了ConstraintValidator接口的类中依赖注入其它Bean
     * 技巧04：实现了ConstraintValidator接口后必须重写 initialize 和 isValid 这两个方法；
     *        1.initialize 方法主要来进行初始化，通常用来获取自定义注解的属性值；
     *        2.isValid 方法主要进行校验逻辑，返回true表示校验通过，返回false表示校验失败，通常根据注解属性值和实体类属性值进行校验判断 [Object:校验字段的属性值]
     */

    @Override
    public void initialize(Age constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //TODO 校验逻辑
        return false;
    }
}
