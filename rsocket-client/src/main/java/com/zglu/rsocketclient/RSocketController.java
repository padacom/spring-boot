package com.zglu.rsocketclient;

import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RSocketController {

    private RSocketRequester rSocketRequester;

    @GetMapping("/get")
    public Publisher<UserMongoVo> get(@PathVariable String id) {
        return rSocketRequester
                .route("get")
                .data(id)
                .retrieveMono(UserMongoVo.class);
    }

    @GetMapping("/fnf")
    public Publisher<Void> fnf() {
        return rSocketRequester
                .route("fnf")
                .data("")
                .send();
    }

    @GetMapping("/rs")
    public Publisher<UserMongoVo> rs() {
        return rSocketRequester
                .route("rs")
                .data("")
                .retrieveFlux(UserMongoVo.class);
    }

}
