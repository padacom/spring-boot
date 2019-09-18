package com.zglu.springboot.api;

import com.aliyun.mq.http.MQProducer;
import com.aliyun.mq.http.model.TopicMessage;
import com.zglu.springboot.common.CustomException;
import com.zglu.springboot.common.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.quartz.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Log
@RestController
@AllArgsConstructor
public class TestRestController {

    private MQProducer mqProducer;
    private JavaMailSender javaMailSender;
    private Scheduler scheduler;

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }

    @GetMapping("/api/1")
    public String test1() {
        throw new CustomException(ResultCode.DATA_NOT_EXIST);
    }

    @GetMapping("/api/2")
    public String test2() {
        throw new RuntimeException();
    }

    @GetMapping("/api/vo1")
    public Test1Vo test1Vo() {
        return new Test1Vo();
    }

    @GetMapping("/api/vo2")
    public Test2Vo test2Vo() {
        return new Test2Vo();
    }

    @GetMapping("/api/vo")
    public TestBaseVo testBaseVo() {
        return new TestBaseVo();
    }

    @PostMapping("/api/vo")
    public TestBaseVo testVo(@RequestBody TestBaseVo vo) {
        return vo;
    }

    @GetMapping("/api/mq")
    public String mq() throws UnsupportedEncodingException {
        TopicMessage msg = new TopicMessage();
        msg.setMessageTag("test");
        msg.setMessageBody("test");
        return mqProducer.publishMessage(msg).toString();
    }

    @GetMapping("/api/mail")
    public String mail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("385861131@qq.com");
        message.setTo("385861131@qq.com");
        message.setSubject("test");
        message.setText("test");
        javaMailSender.send(message);
        return "ok";
    }

    @GetMapping("/api/job")
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
        return "ok";
    }
}
