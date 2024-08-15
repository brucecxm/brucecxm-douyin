package com.bruce.annotation;
import com.bruce.pojo.StringRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER}) // 注解可以用在字段和方法参数上
@Retention(RetentionPolicy.RUNTIME) // 注解保留到运行时
@Constraint(validatedBy = StringRangeValidator.class) // 指定校验逻辑的类
public @interface StringRange {
    String message() default "String length is out of range"; // 默认的校验失败消息
    int min() default 0; // 最小长度，默认为0
    int max() default Integer.MAX_VALUE; // 最大长度，默认为最大整数值
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
