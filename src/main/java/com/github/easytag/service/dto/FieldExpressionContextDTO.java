package com.github.easytag.service.dto;

import lombok.Data;

import java.util.Map;

@Data
public class FieldExpressionContextDTO {
    private String expression;
    private Map<String, FieldLogicDataDTO> variables;
}
