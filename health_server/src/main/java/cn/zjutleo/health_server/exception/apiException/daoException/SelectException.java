package cn.zjutleo.health_server.exception.apiException.daoException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.DaoException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 数据库插入失败异常类
 */
public class SelectException extends DaoException {
    public SelectException(String message) {
        super(message, ApiExceptionCodes.SELECT_ERROR.getValue());
    }

    public SelectException() {
        super(ApiExceptionCodes.INSERT_ERROR.getDesc(), ApiExceptionCodes.SELECT_ERROR.getValue());
    }

    public SelectException(String message, Integer code) {
        super(message, code);
    }
}