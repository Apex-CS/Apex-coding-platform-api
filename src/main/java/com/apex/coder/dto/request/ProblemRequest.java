package com.apex.coder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class ProblemRequest {
    long case_id;
    String session_id;
    String user_name;
}
