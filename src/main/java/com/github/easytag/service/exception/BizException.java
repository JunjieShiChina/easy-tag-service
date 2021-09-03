package com.github.easytag.service.exception;

import com.github.easytag.service.common.ResponseCode;
import lombok.Data;

@Data
public class BizException extends RuntimeException{

    private String code;

    private String errMsg;

    public BizException(String errMsg) {
        this.code = ResponseCode.FAILURE.getCode();
        this.errMsg = errMsg;
    }

    public BizException(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }
}
