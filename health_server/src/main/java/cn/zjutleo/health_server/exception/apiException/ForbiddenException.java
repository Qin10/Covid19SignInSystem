package cn.zjutleo.health_server.exception.apiException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.ApiException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 鉴权错误异常类，对应HTTP403错误
 */
public class ForbiddenException extends ApiException {
    public ForbiddenException() {
        super(ApiExceptionCodes.ACCESS_FORBIDDEN.getDesc(), ApiExceptionCodes.ACCESS_FORBIDDEN.getValue());
    }

    public ForbiddenException(String message) {
        super(message, ApiExceptionCodes.ACCESS_FORBIDDEN.getValue());
    }
}