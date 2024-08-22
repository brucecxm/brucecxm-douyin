package com.bruce.nine;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//使用springtask实现延时任务
//使用springtask实现延时任务
//使用springtask实现延时任务
@Component
public class ScheduleJobs {
    @Scheduled(fixedDelay = 2 * 1000)
    public void fixedDelayJob() throws InterruptedException {
        System.out.println("任务执行，时间：" + LocalDateTime.now());
    }
}
