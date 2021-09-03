package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class DoubleTypeConverter implements FieldTypeConverter {

    private static final DoubleTypeConverter instance = new DoubleTypeConverter();

    private DoubleTypeConverter() {
    }

    public static DoubleTypeConverter getInstance() {
        return instance;
    }

    @Override
    public FieldLogicDataDTO convert(Object targetValue) {
        return new FieldLogicDataDTO(targetValue, FieldDataTypeEnum.DOUBLE);
    }
}
