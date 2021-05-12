package cn.zjutleo.health_server.exception.apiException.daoException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.DaoException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 数据库更新失败异常类
 */
public class UpdateException extends DaoException {
    public UpdateException() {
        super(ApiExceptionCodes.UPDATE_ERROR.getDesc(), ApiExceptionCodes.UPDATE_ERROR.getValue());
    }

    public UpdateException(String message) {
        super(message, ApiExceptionCodes.UPDATE_ERROR.getValue());
    }
}