package com.bruce.ten;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleScheduler {
    @Bean
    public JobDetail sampleJobDetail() {
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger() {
        // 3s 后执行
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(1);
        return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
