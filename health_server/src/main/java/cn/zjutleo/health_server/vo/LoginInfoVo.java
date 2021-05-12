package cn.zjutleo.health_server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 包含token和用户信息的DTO
 */
@Data
@AllArgsConstructor
public class LoginInfoVo {
    /**
     * token令牌
     */
    private String token;
    /**
     * 用户信息
     */
    private UserVo userVo;
}
