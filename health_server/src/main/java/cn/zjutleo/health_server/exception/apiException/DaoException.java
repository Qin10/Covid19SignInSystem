package cn.zjutleo.health_server.exception.apiException;

import cn.zjutleo.health_server.exception.ApiException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 数据库操作异常类
 */
public class DaoException extends ApiException {
    public DaoException() {
    }

    public DaoException(String message, Integer code) {
        super(message, code);
    }
}
