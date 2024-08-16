package com.controller;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {




    @RequestMapping("/user/doLogin")
    public SaResult getList() {
        StpUtil.login(1);
        System.out.println("------------ 访问进来方法doLogin");
        return SaResult.ok();
    }

    @RequestMapping("/admin/doLogin")
    public SaResult getListone() {
        System.out.println("------------ 访问进来方法admin");
        return SaResult.ok();
    }

}

