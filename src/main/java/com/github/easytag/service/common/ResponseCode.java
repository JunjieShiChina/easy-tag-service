package com.github.easytag.service.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS("0", "成功"),
    FAILURE("1", "请求服务发生内部错误，请联系相关同学解决！");
    private final String code;
    private final String msg;

}
