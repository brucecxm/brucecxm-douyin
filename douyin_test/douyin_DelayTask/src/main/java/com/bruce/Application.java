package com.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//       手动无限循环；
//
//        ScheduledExecutorService；
//
//        DelayQueue；
//
//        Redis zset 数据判断的方式；
//
//        Redis 键空间通知的方式；
//
//        Netty 提供的 HashedWheelTimer 工具类；
//
//        RabbitMQ 死信队列；
//
//        RabbitMQ 延迟消息插件 rabbitmq-delayed-message-exchange；
//
//        Spring Scheduled；
//
//        Quartz。

@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
