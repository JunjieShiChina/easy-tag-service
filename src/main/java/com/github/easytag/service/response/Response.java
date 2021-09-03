package com.github.easytag.service.response;

import com.github.easytag.service.common.ResponseCode;
import lombok.Data;

@Data
public class Response<T> {

    private String code;
    private String msg;
    private T data;

    public static <T> Response<T> success() {
        Response<T> resp = new Response();
        resp.setCode(ResponseCode.SUCCESS.getCode());
        resp.setMsg(ResponseCode.SUCCESS.getMsg());
        return resp;
    }

    public static <T> Response<T> success(T data) {
        Response<T> resp = new Response();
        resp.setCode(ResponseCode.SUCCESS.getCode());
        resp.setMsg(ResponseCode.SUCCESS.getMsg());
        resp.setData(data);
        return resp;
    }

    public static <T> Response<T> fail(String msg) {
        Response<T> resp = new Response();
        resp.setCode(ResponseCode.FAILURE.getCode());
        resp.setMsg(msg);
        return resp;
    }

    public static <T> Response<T> fail(String msg, T data) {
        Response<T> resp = new Response();
        resp.setCode(ResponseCode.FAILURE.getCode());
        resp.setMsg(msg);
        resp.setData(data);
        return resp;
    }

    public static <T> Response<T> fail(ResponseCode code) {
        Response<T> resp = new Response();
        resp.setCode(code.getCode());
        resp.setMsg(code.getMsg());
        return resp;
    }
}
