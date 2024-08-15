package com.bruce.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 表示该注解可以标记在方法上
@Retention(RetentionPolicy.RUNTIME) // 表示该注解会保留到运行时
public @interface MyAnnotation {
    String value() default "default value"; // 定义一个属性，可以在使用时指定值
}
