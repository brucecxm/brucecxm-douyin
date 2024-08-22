package com.bruce.six;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class DelayTaskExample {
    public static void main(String[] args) {
        System.out.println("程序启动时间：" + LocalDateTime.now());
        NettyTask();
    }

    /**
     * 基于 Netty 的延迟任务
     */
    private static void NettyTask() {
        // 创建延迟任务实例
        HashedWheelTimer timer = new HashedWheelTimer(3, // 时间间隔
                TimeUnit.SECONDS,
                100); // 时间轮中的槽数
        // 创建一个任务
        TimerTask task = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("执行任务" +
                        " ，执行时间：" + LocalDateTime.now());
            }
        };
        // 将任务添加到延迟队列中
        timer.newTimeout(task, 0, TimeUnit.SECONDS);

    }
}
