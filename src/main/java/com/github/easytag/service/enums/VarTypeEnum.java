package com.github.easytag.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VarTypeEnum {
    CONSTANT(0, "常量"),
    VARIABLE(1, "变量");
    private Integer code;
    private String desc;
}
