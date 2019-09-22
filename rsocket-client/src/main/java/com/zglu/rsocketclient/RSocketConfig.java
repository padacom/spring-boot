package com.zglu.rsocketclient;

import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;

@Configuration
public class RSocketConfig {

    @Bean
    RSocketRequester rSocketRequester(RSocketStrategies rSocketStrategies) {
        return RSocketRequester.builder()
                .rsocketStrategies(rSocketStrategies)
                .connect(TcpClientTransport.create(7000))
                .block();
    }
}
