package com.bruce;
import com.bruce.annotation.MyAnnotation;
import com.bruce.pojo.MyClass;

import java.lang.reflect.Method;

public class AnnotationReader {

    public static void main(String[] args) throws Exception {
        Method method = MyClass.class.getMethod("myMethod");

        // 检查方法是否标记了自定义注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value: " + annotation.value());
        } else {
            System.out.println("Method is not annotated with @MyAnnotation");
        }
    }
}
