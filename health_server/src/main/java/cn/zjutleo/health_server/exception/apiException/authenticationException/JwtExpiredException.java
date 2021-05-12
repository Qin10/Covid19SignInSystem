package cn.zjutleo.health_server.exception.apiException.authenticationException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.AuthenticationException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: token过期异常
 */
public class JwtExpiredException extends AuthenticationException {
    public JwtExpiredException() {
        super(ApiExceptionCodes.TOKEN_EXPIRED.getDesc(), ApiExceptionCodes.TOKEN_EXPIRED.getValue());
    }

    public JwtExpiredException(String message) {
        super(message, ApiExceptionCodes.TOKEN_EXPIRED.getValue());
    }
}
