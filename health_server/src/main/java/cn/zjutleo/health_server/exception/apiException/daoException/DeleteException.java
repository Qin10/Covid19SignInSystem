package cn.zjutleo.health_server.exception.apiException.daoException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.DaoException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 数据库删除失败异常类
 */
public class DeleteException extends DaoException {
    public DeleteException(String message) {
        super(message, ApiExceptionCodes.DELETE_ERROR.getValue());
    }

    public DeleteException() {
        super(ApiExceptionCodes.DELETE_ERROR.getDesc(), ApiExceptionCodes.DELETE_ERROR.getValue());
    }
}