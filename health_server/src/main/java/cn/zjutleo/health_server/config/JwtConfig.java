package cn.zjutleo.health_server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: JWT配置文件类
 */
@ConfigurationProperties("jwt-config")
@Data
public class JwtConfig {
    private String secret;
    private int expireTime;
    private int refreshTokenExpireTime;
}