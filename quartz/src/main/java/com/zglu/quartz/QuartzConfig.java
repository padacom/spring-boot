package com.zglu.quartz;

import lombok.extern.java.Log;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Log
@Configuration
@EnableScheduling
public class QuartzConfig {

    @Scheduled(cron = "*/5 * * * * ?")
    public void test() {
        log.info("注解方式每5秒定时打印");
    }

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(TestJob.class).withIdentity("testJob").storeDurably().build();
    }

    @Bean
    public Trigger trigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("testJob")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
