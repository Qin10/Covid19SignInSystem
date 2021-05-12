package cn.zjutleo.health_server.pojo;

import lombok.Data;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 用户表
 */
@Data
public class Oauth {
    /**
     * 被授权用户id
     */
    private Integer userId;

    /**
     * 授权类型
     */
    private String oauthType;

    /**
     * 授权码(手机号，微信号等)
     */
    private String oauthId;

    /**
     * 微信unionid(预留字段)
     */
    private String unionid;

    /**
     * 授权秘钥(预留字段)
     */
    private String credential;
}

