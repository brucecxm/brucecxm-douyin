package com.bruce;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DouyinScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(DouyinScheduleApplication.class);
    }

    /**
     * mybatis-plus乐观锁支持
     * @return
     */
    @Bean
    public MybatisPlusInterceptor optimisticLockerInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }



}
