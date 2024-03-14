package com.apex.coder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    //private static final String TOPIC = "";

    //@Scheduled(fixedRate = 10000)
    public void sendMessage(String message, String topic) {
        log.info(message);
        log.info(topic);
        kafkaTemplate.send(topic, message).whenComplete(
                (stringStringSendResult, throwable) -> log.info("Message resut {}", stringStringSendResult)
        );
    }
}
