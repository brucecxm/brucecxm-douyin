package com.bruce.pojo;

import com.bruce.annotation.StringRange;
import lombok.Data;

@Data
public class User {

    @StringRange(min = 3, max = 20, message = "Username length should be between 3 and 20")
    private String username;

    // 其他字段和方法
}
