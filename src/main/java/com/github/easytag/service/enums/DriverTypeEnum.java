package com.github.easytag.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 驱动类型枚举
 */
@AllArgsConstructor
@Getter
public enum DriverTypeEnum {
    H2("org.h2.Driver"),
    MYSQL("com.mysql.jdbc.Driver"),
    ;

    private String driverClassName;
}
