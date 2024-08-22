package com.bruce.ten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * SpringBoot 项目启动后执行
 */
@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private SampleScheduler sampleScheduler;

    @Override
    public void run(String... args) throws Exception {
        // 启动定时任务
        schedulerFactoryBean.getScheduler().scheduleJob(
                sampleScheduler.sampleJobTrigger());
    }
}
