package com.bruce.pojo;

import com.bruce.annotation.StringRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义字符串范围校验器
 */
public class StringRangeValidator implements ConstraintValidator<StringRange, String> {

    private int min; // 最小长度
    private int max; // 最大长度

    @Override
    public void initialize(StringRange constraintAnnotation) {
        min = constraintAnnotation.min(); // 初始化最小长度
        max = constraintAnnotation.max(); // 初始化最大长度
    }

    /**
     * 校验方法，判断字符串长度是否在指定范围内
     *
     * @param value   要校验的字符串值
     * @param context 校验器上下文
     * @return 校验结果，true表示校验通过，false表示校验不通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // 如果值为null，不做校验
        }
        int length = value.length(); // 获取字符串长度
        return length >= min && length <= max; // 判断长度是否在指定范围内
    }
}
