package com.apex.coder.controller;

import com.apex.coder.dto.sockets.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@Slf4j
@RestController
public class SocketController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/broadcast")
    @SendTo("/topic/reply")
    public String broadcastMessage(@Payload final String message, @Header("simpSessionId") String sessionId) throws Exception {
        return "You have received a message: " + message;
    }
}
