package cn.zjutleo.health_server.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 微信注册信息DTO
 */
@Data
public class WechatRegisterUserDto {
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 微信code
     */
    @NotEmpty(message = "code不能为空")
    private String code;

    /**
     * 头像URL
     */
    private String avatarUrl;
}
