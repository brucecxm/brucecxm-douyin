//package com.bruce.controller;
//
//
//import com.bruce.pojo.LoginDto;
//import com.bruce.service.SysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
//@RestController
//public class SysUserController {
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @PostMapping("/login")
//    public String login(@RequestBody LoginDto loginDto) {
//        return sysUserService.login(loginDto);
//    }
//}
