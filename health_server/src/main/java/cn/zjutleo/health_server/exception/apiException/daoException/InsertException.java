package cn.zjutleo.health_server.exception.apiException.daoException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.DaoException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 数据库插入失败异常类
 */
public class InsertException extends DaoException {
    public InsertException(String message) {
        super(message, ApiExceptionCodes.INSERT_ERROR.getValue());
    }

    public InsertException() {
        super(ApiExceptionCodes.INSERT_ERROR.getDesc(), ApiExceptionCodes.INSERT_ERROR.getValue());
    }

    public InsertException(String message, Integer code) {
        super(message, code);
    }
}