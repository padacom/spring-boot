package com.zglu.springboot.config;

import com.aliyun.mq.http.MQConsumer;
import com.aliyun.mq.http.model.Message;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Log
@Component
@AllArgsConstructor
public class MQRunner implements ApplicationRunner {

    private MQConsumer mqConsumer;

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run(ApplicationArguments args) {
        log.info("Started MQRunner");
        while (true) {
            try {
                List<Message> messageList = mqConsumer.consumeMessage(3, 3);
                List<String> handles = new ArrayList<>();
                if (messageList != null) {
                    messageList.forEach(m -> {
                        log.info(m.toString());
                        handles.add(m.getReceiptHandle());
                    });
                    mqConsumer.ackMessage(handles);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
