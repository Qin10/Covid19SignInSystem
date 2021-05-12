package cn.zjutleo.health_server.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 服务器抛出(接口)异常类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends Exception{
    private Integer code;

    public ApiException(String message, Integer code){
        super(message);
        this.code = code;
    }

    public ApiException(){
        super();
    }
}
