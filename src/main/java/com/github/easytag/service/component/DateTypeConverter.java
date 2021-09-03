package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class DateTypeConverter implements FieldTypeConverter {

    private static final DateTypeConverter instance = new DateTypeConverter();

    private DateTypeConverter() {
    }

    public static DateTypeConverter getInstance() {
        return instance;
    }

    @Override
    public FieldLogicDataDTO convert(Object targetValue) {
        return new FieldLogicDataDTO(targetValue, FieldDataTypeEnum.DATE);
    }
}
