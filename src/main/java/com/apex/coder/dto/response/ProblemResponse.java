package com.apex.coder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProblemResponse {
    String description;
    String code_starter;
    String input_values;
}
