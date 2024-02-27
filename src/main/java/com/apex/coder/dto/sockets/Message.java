package com.apex.coder.dto.sockets;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private String from;
    private String text;
}