package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class LongTypeConverter implements FieldTypeConverter {

    private static final LongTypeConverter instance = new LongTypeConverter();

    private LongTypeConverter() {
    }

    public static LongTypeConverter getInstance() {
        return instance;
    }

    @Override
    public FieldLogicDataDTO convert(Object targetValue) {
        return new FieldLogicDataDTO(targetValue, FieldDataTypeEnum.LONG);
    }
}
