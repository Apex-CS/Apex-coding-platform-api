package com.apex.coder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic","/queue");
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-endpoint")
                .setAllowedOrigins("https://afdev.ddns.net", "http://localhost:3000")
                .withSockJS();

        List<Integer> arr = List.of(1,2,4,3,-3,4,-2,-7,5,-1);
        var res = arr.stream().filter(x -> x>0).collect(Collectors.toList());
        var ress = arr.stream().filter(x -> x<0 && res.contains(x)).toList();
        System.out.print(res);
    }
}
