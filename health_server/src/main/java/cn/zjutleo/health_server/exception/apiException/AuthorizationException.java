package cn.zjutleo.health_server.exception.apiException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.ApiException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 授权异常类
 */
public class AuthorizationException extends ApiException {
    public AuthorizationException() {
        super(ApiExceptionCodes.AUTHORIZATION_FAIL.getDesc(), ApiExceptionCodes.AUTHORIZATION_FAIL.getValue());
    }

    public AuthorizationException(String message) {
        super(message, ApiExceptionCodes.AUTHORIZATION_FAIL.getValue());
    }
}