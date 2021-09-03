package com.github.easytag.service.dto;

import lombok.Data;

@Data
public class FieldExpressBranchDTO {
    private String judgeType = "AND";
    private FieldExpressItemDTO fieldExpressItem;
    private FieldExpressConditionDTO fieldExpressCondition;
}
