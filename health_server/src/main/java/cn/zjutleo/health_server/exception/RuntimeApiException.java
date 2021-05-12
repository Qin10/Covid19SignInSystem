package cn.zjutleo.health_server.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 运行时API异常类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RuntimeApiException extends RuntimeException {
    private Integer code;

    public RuntimeApiException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public RuntimeApiException() {
        super();
    }
}
