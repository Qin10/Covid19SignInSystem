package cn.zjutleo.health_server.vo;

import cn.zjutleo.health_server.util.TimeUtil;
import lombok.Data;

import java.util.Date;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 响应数据封装VO
 */
@Data
public class ResponseBean<T> {
    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 响应时间
     */
    private String time;

    public ResponseBean(int code, String msg, T data, String time) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = time;
    }

    public ResponseBean(int code, String msg, T data) {
        this(code, msg, data, TimeUtil.getFormattedTime(new Date()));
    }

    public ResponseBean(T data) {
        this(200, "succ", data);
    }
}
