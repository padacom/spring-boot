package com.zglu.api;

import com.aliyun.mq.http.MQProducer;
import com.aliyun.mq.http.model.TopicMessage;
import com.zglu.mysqldao.User;
import com.zglu.solrdao.UserSolr;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Log
@RestController
@AllArgsConstructor
public class TestController {

    private final MQProducer mqProducer;
    private final JavaMailSender javaMailSender;
    private final UserService userService;
    private final UserSolrService userSolrService;

    @GetMapping("/vo")
    public TestBaseVo vo() {
        TestBaseVo testBaseVo = new TestBaseVo();
        testBaseVo.set("test");
        return testBaseVo;
    }

    @GetMapping("/vo1")
    public TestVo vo1() {
        TestVo testVo = new TestVo();
        testVo.set("test");
        return testVo;
    }

    @GetMapping("/mq")
    public String mq() throws UnsupportedEncodingException {
        TopicMessage msg = new TopicMessage();
        msg.setMessageTag("test");
        msg.setMessageBody("test");
        return mqProducer.publishMessage(msg).toString();
    }

    @GetMapping("/mail")
    public String mail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("385861131@qq.com");
        message.setTo("385861131@qq.com");
        message.setSubject("test");
        message.setText("test");
        javaMailSender.send(message);
        return "ok";
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable int id) {
        return userService.get(id);
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/user-solr/{id}")
    public UserSolr userSolr(@PathVariable int id) {
        return userSolrService.get(id);
    }

    @PostMapping("/user-solr")
    public UserSolr userSolr(@RequestBody UserSolr user) {
        return userSolrService.add(user);
    }
}
