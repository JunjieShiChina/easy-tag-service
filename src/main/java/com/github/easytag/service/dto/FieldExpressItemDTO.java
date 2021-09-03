package com.github.easytag.service.dto;

import lombok.Data;

@Data
public class FieldExpressItemDTO {
    private String logicalOperator;
    private Object sourceData;
    private String sourceDataType;
    private Object targetData;
    private String targetDataType;
}
