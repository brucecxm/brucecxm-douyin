package com.bruce.two;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayTaskExample {
    public static void main(String[] args) {
        System.out.println("程序启动时间：" + LocalDateTime.now());
        scheduledExecutorServiceTask();
    }

    /**
     * ScheduledExecutorService 实现固定频率一直循环执行任务
     */
    public static void scheduledExecutorServiceTask() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(
                new Runnable() {
                    @Override
                    public void run() {
                        // 执行任务的业务代码
                        System.out.println("执行任务" +
                                " ，执行时间：" + LocalDateTime.now());
                    }
                },
                2, // 初次执行间隔
                2, // 2s 执行一次
                TimeUnit.SECONDS);
    }
}
