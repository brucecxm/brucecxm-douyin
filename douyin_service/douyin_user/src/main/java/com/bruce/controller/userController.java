package com.bruce.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @PostMapping("/login")
public void Login(int id)
{
// 会话登录：参数填写要登录的账号id，建议的数据类型：long | int | String， 不可以传入复杂类型，如：User、Admin 等等
    StpUtil.login(id);
}

    @GetMapping("/userid")
    public int userid()
    {
// 获取当前会话账号id, 如果未登录，则抛出异常：`NotLoginException`
        return StpUtil.getLoginIdAsInt();       // 获取当前会话账号id, 并转化为`int`类型
    }


}
