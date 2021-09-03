package com.github.easytag.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FieldDataTypeEnum {
    STRING(0, "STRING"),
    INTEGER(1, "INTEGER"),
    DOUBLE(2, "DOUBLE"),
    DATE(3, "DATE"),
    LONG(4, "LONG"),
    FIELD(5, "FIELD");

    private Integer code;
    private String desc;

    public static FieldDataTypeEnum findByName(String dataType) {
        FieldDataTypeEnum[] dataTypeEnums = FieldDataTypeEnum.values();
        for (FieldDataTypeEnum dataTypeEnum : dataTypeEnums) {
            if(dataTypeEnum.name().equals(dataType)) {
                return dataTypeEnum;
            }
        }
        return null;
    }

    public static FieldDataTypeEnum findByCode(Integer code) {
        FieldDataTypeEnum[] dataTypeEnums = FieldDataTypeEnum.values();
        for (FieldDataTypeEnum dataTypeEnum : dataTypeEnums) {
            if(dataTypeEnum.getCode().equals(code)) {
                return dataTypeEnum;
            }
        }
        return null;
    }

}
