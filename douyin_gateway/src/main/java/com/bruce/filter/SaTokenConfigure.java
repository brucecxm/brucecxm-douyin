package com.bruce.filter;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfigure {
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                .addInclude("/**")    // 拦截所有路径
                .addExclude("/user/login")  // 排除登录接口
                .setAuth(obj -> {
                    // 检查是否登录
                    StpUtil.checkLogin();
                })
                .setError(e -> {
                    return SaResult.error(e.getMessage()); // 自定义错误返回
                });
    }
}
