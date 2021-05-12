package cn.zjutleo.health_server.exception.apiException.authenticationException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.AuthenticationException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 未找到token字段异常类
 */
public class TokenNotFoundException extends AuthenticationException {
    public TokenNotFoundException() {
        super(ApiExceptionCodes.TOKEN_NOT_FOUND.getDesc(), ApiExceptionCodes.TOKEN_NOT_FOUND.getValue());
    }

    public TokenNotFoundException(String message) {
        super(message, ApiExceptionCodes.TOKEN_NOT_FOUND.getValue());
    }
}
