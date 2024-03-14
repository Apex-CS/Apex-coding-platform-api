package com.apex.coder.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {
    private final List<String> messages = new ArrayList<>();

    private static final String TOPIC = "my_kafka_topic";

    @KafkaListener(topics = TOPIC, groupId = "messageGroup")
    public void listen(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        List<String> currentMessages = new ArrayList<>(messages);
        messages.clear();
        return currentMessages;
    }
}
