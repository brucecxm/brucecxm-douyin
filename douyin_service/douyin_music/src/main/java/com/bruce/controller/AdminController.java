package com.bruce.controller;
import com.bruce.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

    @GetMapping("/one")
    public String admin() {
        return "Welcome Admin!";
    }

//    BindingResult 在 Spring MVC 中是一个非常重要的类，用来支持数据校验过程中的错误处理和结果返回。
//    BindingResult 在 Spring MVC 中是一个非常重要的类，用来支持数据校验过程中的错误处理和结果返回。
//    BindingResult 在 Spring MVC 中是一个非常重要的类，用来支持数据校验过程中的错误处理和结果返回。
//    BindingResult 在 Spring MVC 中是一个非常重要的类，用来支持数据校验过程中的错误处理和结果返回。
//    BindingResult 在 Spring MVC 中是一个非常重要的类，用来支持数据校验过程中的错误处理和结果返回。
    @PostMapping("/users")
    public String createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            // 处理错误信息，例如返回错误提示或者其他处理
            return "Validation failed: " + errors.toString();
        }

        // 校验通过，处理正常逻辑
        return user.getUsername();
    }


    @GetMapping("/public")
    public String publicPage() {
        return "This is a public page.";
    }
}
