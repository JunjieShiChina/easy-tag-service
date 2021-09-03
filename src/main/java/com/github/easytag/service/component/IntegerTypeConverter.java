package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class IntegerTypeConverter implements FieldTypeConverter {

    private static final IntegerTypeConverter instance = new IntegerTypeConverter();

    private IntegerTypeConverter() {
    }

    public static IntegerTypeConverter getInstance() {
        return instance;
    }

    @Override
    public FieldLogicDataDTO convert(Object targetValue) {
        return new FieldLogicDataDTO(targetValue, FieldDataTypeEnum.INTEGER);
    }
}
