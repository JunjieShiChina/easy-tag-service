package com.github.easytag.service.enums;

public enum FromTypeEnum {
    FIXED_VALUE(0, "固定值"),
    SQL_VALUE(1, "SQL");
    private Integer code;
    private String desc;

    FromTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
