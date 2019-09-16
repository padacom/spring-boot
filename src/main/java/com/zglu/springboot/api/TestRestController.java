package com.zglu.springboot.api;

import com.aliyun.mq.http.MQProducer;
import com.aliyun.mq.http.model.TopicMessage;
import com.zglu.springboot.common.CustomException;
import com.zglu.springboot.common.ResultCode;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
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
}