package com.apex.coder.dto.response;

import com.apex.coder.dto.CodeResults;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class CodeRunResponse {
    public LocalDateTime timestamp;
    public double duration;
    public CodeResults result;
    public String output;
}
