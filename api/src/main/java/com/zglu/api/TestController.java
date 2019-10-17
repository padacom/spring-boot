package com.zglu.api;

import com.alibaba.fastjson.JSON;
import com.aliyun.mq.http.MQProducer;
import com.aliyun.mq.http.model.TopicMessage;
import com.zglu.mysqldao.User;
import com.zglu.mysqldao.UserRoleVo;
import com.zglu.mysqldao.UserVo;
import com.zglu.solrdao.UserSolr;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

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

    //测试json解析时，不为基础属性赋值是否报错
    @GetMapping("/user-vo/{id}")
    public UserVo userVo(@PathVariable int id) {
        return JSON.parseObject(JSON.toJSONString(userService.get(id)), UserVo.class);
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

    @GetMapping("/user-role/{id}")
    public List<UserRoleVo> userRole(@PathVariable int id) {
        return userService.userRole(id);
    }

    @GetMapping("/user-role-hql/{id}")
    public List<UserRoleVo> userRoleHql(@PathVariable int id) {
        return userService.userRoleHql(id);
    }

    @GetMapping("/user-vo-hql/{id}")
    public List<UserVo> findVoById(@PathVariable int id) {
        return userService.findVoById(id);
    }

    //测试修改list内元素，修改的是元素本身，而不是容器内元素
    @GetMapping("/list-test")
    public void listTest() {
        List<UserVo> list = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setCreatedBy(10);
        list.add(userVo);
        List<UserVo> a = list.stream().filter(m -> m.getCreatedBy() == 10).collect(Collectors.toList());
        a.forEach(m -> m.setCreatedBy(11));
        System.out.println(a);
        System.out.println(list);
    }

    public static void main(String[] args) {

    }
}
