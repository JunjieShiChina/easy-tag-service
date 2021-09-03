package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class StringTypeConverter implements FieldTypeConverter {

    private static final StringTypeConverter instance = new StringTypeConverter();

    private StringTypeConverter() {
    }

    public static StringTypeConverter getInstance() {
        return instance;
    }

    @Override
    public FieldLogicDataDTO convert(Object targetValue) {
        return new FieldLogicDataDTO(targetValue, FieldDataTypeEnum.STRING);
    }
}
