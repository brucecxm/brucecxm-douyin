//package com.bruce.config;
//
//import com.bruce.service.MyUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // 禁用 CSRF（跨站请求伪造）保护
//                .csrf().disable()
//                // 配置请求授权
//                .authorizeRequests()
//                // 对于 "/login" 和 "/static/**" 路径，不需要认证即可访问
//                .antMatchers("/login", "/static/**","/user/hello").permitAll()
//                // 其他任何请求都需要认证
//                .anyRequest().authenticated()
//                .and()
//                // 配置表单登录
//                .formLogin()
//                // 指定登录页面的 URL
//                .loginPage("/user/login")
//                // 指定处理登录请求的 URL
//                .loginProcessingUrl("/user/login")
//                // 允许所有用户访问登录页面和登录请求
//                .permitAll()
//                .and()
//                // 配置注销
//                .logout()
//                // 允许所有用户访问注销请求
//                .permitAll();
//    }
//
//
//    @Bean
//    public MyUserDetailsService customUserDetailsService() {
//        return new MyUserDetailsService();
//    }
//}
