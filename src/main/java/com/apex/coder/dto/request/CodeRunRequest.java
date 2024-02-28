package com.apex.coder.dto.request;

import com.apex.coder.dto.CodeResults;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CodeRunRequest {
    String code;
    long case_id;
    String session_id;
    String input_values;
}
