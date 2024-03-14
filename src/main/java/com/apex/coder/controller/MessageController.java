package com.apex.coder.controller;

import com.apex.coder.dto.request.MessageRequest;
import com.apex.coder.service.KafkaConsumerService;
import com.apex.coder.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllMessages() {
        return ResponseEntity.ok(kafkaConsumerService.getMessages());
    }
    @PostMapping(value = "/new")
    public ResponseEntity<List<String>>  addNewMessage(@RequestBody final MessageRequest request){
        kafkaProducerService.sendMessage(request.getMessage(), request.getSession_id());
        return ResponseEntity.ok(kafkaConsumerService.getMessages());
    }

}
