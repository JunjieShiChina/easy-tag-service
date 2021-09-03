package com.github.easytag.service.dto;

import lombok.Data;

import java.util.List;

/**
 * 字段表达式
 */
@Data
public class FieldExpressConditionDTO {
    private List<FieldExpressBranchDTO> fieldExpressBranches;
}
