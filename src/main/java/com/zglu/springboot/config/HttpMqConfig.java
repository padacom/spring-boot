package com.zglu.springboot.config;

import com.aliyun.mq.http.MQClient;
import com.aliyun.mq.http.MQConsumer;
import com.aliyun.mq.http.MQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpMqConfig {

    @Value("${custom.mq.url}")
    private String accountEndpoint;
    @Value("${custom.mq.id}")
    private String accessId;
    @Value("${custom.mq.key}")
    private String accessKey;
    @Value("${custom.mq.topic}")
    private String topicName;
    @Value("${custom.mq.groupId}")
    private String groupId;

    @Bean
    MQClient mqClient() {
        return new MQClient(accountEndpoint, accessId, accessKey);
    }

    @Bean
    MQProducer mqProducer(MQClient mqClient) {
        return mqClient.getProducer(topicName);
    }

    @Bean
    MQConsumer mqConsumer(MQClient mqClient) {
        return mqClient.getConsumer(topicName, groupId);
    }
}