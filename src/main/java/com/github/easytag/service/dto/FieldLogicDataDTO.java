package com.github.easytag.service.dto;

import com.github.easytag.service.enums.FieldDataTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldLogicDataDTO {
    private Object value;
    private FieldDataTypeEnum fieldDataType;
}
