package com.apex.coder.dto.sockets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OutputMessage {

    private String from;
    private String text;

}
