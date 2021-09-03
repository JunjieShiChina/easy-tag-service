package com.github.easytag.service.component;

import com.github.easytag.core.exception.UnSupportDataTypeException;
import com.github.easytag.service.enums.FieldDataTypeEnum;

public class FieldTypeConverterFactory {
    public static FieldTypeConverter getConverter(FieldDataTypeEnum targetType) {
        switch (targetType) {
            case STRING: return StringTypeConverter.getInstance();
            case INTEGER: return IntegerTypeConverter.getInstance();
            case DATE: return DateTypeConverter.getInstance();
            case LONG: return LongTypeConverter.getInstance();
            case DOUBLE: return DoubleTypeConverter.getInstance();
            case FIELD: return VarTypeConverter.getInstance();
            default: throw new UnSupportDataTypeException("Unexpected value: " + targetType);
        }
    }
}
