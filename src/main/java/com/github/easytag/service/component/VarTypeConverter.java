package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class VarTypeConverter implements FieldTypeConverter{

    private static final VarTypeConverter instance = new VarTypeConverter();

    private VarTypeConverter() {
    }

    public static VarTypeConverter getInstance() {
        return instance;
    }

    @Override
    public FieldLogicDataDTO convert(Object targetValue) {
        return new FieldLogicDataDTO(targetValue, FieldDataTypeEnum.FIELD);
    }

}
