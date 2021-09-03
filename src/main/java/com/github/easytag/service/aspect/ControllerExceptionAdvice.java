package com.github.easytag.service.aspect;


import com.github.easytag.service.common.ResponseCode;
import com.github.easytag.service.exception.BizException;
import com.github.easytag.service.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * controller层统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {


    /**
     * 拦截捕捉自定义异常 HttpRequestMethodNotSupportedException.class
     * @param ex 异常
     * @return BaseResponse响应
     */
    @ResponseBody
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Response buExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        Response response = new Response();
        response.setCode(ResponseCode.FAILURE.getCode());
        response.setMsg("请求方式错误");
        return response;
    }

    /**
     * 拦截捕捉自定义异常 BizException.class
     * @param ex 异常
     * @return BaseResponse响应
     */
    @ResponseBody
    @ExceptionHandler(value = BizException.class)
    public Response buExceptionHandler(BizException ex) {
        Response response = new Response();
        response.setCode(ex.getCode());
        response.setMsg(ex.getErrMsg());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public Response buExceptionHandler(Exception ex) {
        log.error("系统异常.e:{}", ex);
        Response baseResponse = new Response();
        baseResponse.setCode(ResponseCode.FAILURE.getCode());
        baseResponse.setMsg("服务器开了点小差,请联系相关运维人员。");
        return baseResponse;
    }

}
