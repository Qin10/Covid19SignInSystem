package cn.zjutleo.health_server.exception.apiException.daoException.insertException;

import cn.zjutleo.health_server.constants.ApiExceptionCodes;
import cn.zjutleo.health_server.exception.apiException.daoException.InsertException;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 用户已存在异常类
 */
public class AccountExistedException extends InsertException {
    public AccountExistedException(String message) {
        super(message, ApiExceptionCodes.ACCOUNT_EXISTED.getValue());
    }

    public AccountExistedException() {
        super(ApiExceptionCodes.ACCOUNT_EXISTED.getDesc(), ApiExceptionCodes.ACCOUNT_EXISTED.getValue());
    }
}