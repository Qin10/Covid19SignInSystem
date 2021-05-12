package cn.zjutleo.health_server.exception.apiException;

import cn.zjutleo.health_server.exception.ApiException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 鉴权相关异常类
 */
public class AuthenticationException extends ApiException {
    public AuthenticationException() {
    }

    public AuthenticationException(String message, Integer code) {
        super(message, code);
    }
}
