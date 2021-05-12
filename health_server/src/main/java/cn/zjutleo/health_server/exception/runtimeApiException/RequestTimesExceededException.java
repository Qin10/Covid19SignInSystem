package cn.zjutleo.health_server.exception.runtimeApiException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.RuntimeApiException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 访问限制异常类
 */
public class RequestTimesExceededException extends RuntimeApiException {
    public RequestTimesExceededException() {
        super(ApiExceptionCodes.REQUEST_TIMES_EXCEEDED.getDesc(), ApiExceptionCodes.REQUEST_TIMES_EXCEEDED.getValue());
    }

    public RequestTimesExceededException(String message) {
        super(message, ApiExceptionCodes.REQUEST_TIMES_EXCEEDED.getValue());
    }
}