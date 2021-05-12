package cn.zjutleo.health_server.vo;

import lombok.Data;

@Data
public class OauthVo {
    /**
    * 授权类型
    */
    private String oauthType;

    /**
    * 授权码(手机号，微信号等)
    */
    private String oauthId;
}