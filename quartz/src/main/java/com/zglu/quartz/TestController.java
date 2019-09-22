package com.zglu.quartz;

import lombok.AllArgsConstructor;
import org.quartz.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private final Scheduler scheduler;

    @GetMapping
    public String job() throws SchedulerException {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/10 * * * * ?");
        TriggerKey triggerKey = TriggerKey.triggerKey("testJob");
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        trigger = trigger.getTriggerBuilder()
                .withIdentity(triggerKey)
                .withSchedule(scheduleBuilder)
                .build();
        //重启触发器
        scheduler.rescheduleJob(triggerKey, trigger);
        return "将定时器设定为10秒";
    }
}
