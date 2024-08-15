package com.bruce.config;import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 指定要扫描的包路径，这里替换为你的 controller 所在的包名
                .apis(RequestHandlerSelectors.basePackage("com.bruce.controller"))
                // 指定路径处理策略，这里使用所有路径
                .paths(PathSelectors.any())
                .build()
                // 设置 API 信息
                .apiInfo(apiInfo());
    }



    /**
     * 展示 controller 包下所有的接口
     */
    @Bean
    public Docket docket1() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("mike") // 修改组名为 "mike"
                // 配置接口信息
                .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors
                        .basePackage("com.bruce.controller") // 扫描指定包下的接口，最为常用
                )
                .paths(PathSelectors
                        .any() // 满足条件的路径，该断言总为true
                )
                .build();
    }

    /**
     * 展示路径为 /error 的所有接口（基础接口）
     */
    @Bean
    public Docket docket2() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("yank") // 修改组名为 "yank"
                // 配置接口信息
                .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors
                        .any() // 扫描全部的接口，默认
                )
                .paths(PathSelectors
                        .ant("/error") // 满足字符串表达式路径
                )
                .build();
    }






    private ApiInfo apiInfo() {
        return new ApiInfo(
                // API 标题
                "我的优秀 API",
                // API 描述
                "这个 API 提供了...的功能",
                // API 版本
                "API V1.0",
                // 服务条款 URL
                "Terms of service URL",
                // 联系信息，用于显示在文档中
                new Contact("你的名字", "你的网站", "你的邮箱"),
                // 许可证信息，用于显示在文档中
                "API 许可证",
                // 许可证 URL
                "API license URL",
                // 空列表，表示无额外的 vendor 扩展信息
                Collections.emptyList());
    }
}
