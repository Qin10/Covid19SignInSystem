package cn.zjutleo.health_server.exception.apiException.authenticationException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.AuthenticationException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 无权限异常
 */
public class PermissionDeniedException extends AuthenticationException {
    public PermissionDeniedException() {
        super(ApiExceptionCodes.PERMISSION_DENIED.getDesc(), ApiExceptionCodes.PERMISSION_DENIED.getValue());
    }

    public PermissionDeniedException(String message) {
        super(message, ApiExceptionCodes.PERMISSION_DENIED.getValue());
    }
}
