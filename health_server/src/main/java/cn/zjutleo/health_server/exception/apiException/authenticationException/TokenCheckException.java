package cn.zjutleo.health_server.exception.apiException.authenticationException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.AuthenticationException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: token校验异常类
 */
public class TokenCheckException extends AuthenticationException {
    public TokenCheckException() {
        super(ApiExceptionCodes.TOKEN_CHECK_FAIL.getDesc(), ApiExceptionCodes.TOKEN_CHECK_FAIL.getValue());
    }

    public TokenCheckException(String message) {
        super(message, ApiExceptionCodes.TOKEN_CHECK_FAIL.getValue());
    }
}
