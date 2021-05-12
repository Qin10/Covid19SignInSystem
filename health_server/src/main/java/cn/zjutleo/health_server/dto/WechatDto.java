package cn.zjutleo.health_server.dto;

import lombok.Data;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/10
 * @description: 微信小程序鉴权DTO
 */
@Data
public class WechatDto {
    /**
     * 用户openId
     */
    private String openid;

    /**
     * 用户session_key
     */
    private String session_key;

    /**
     * 用户unionid
     */
    private String unionid;

    /**
     * 错误码
     */
    private int errcode;

    /**
     * 错误信息
     */
    private String errmsg;
}
