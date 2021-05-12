package cn.zjutleo.health_server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/10
 * @description: 小程序配置类
 */
@ConfigurationProperties("wechat")
@Data
public class WechatConfig {
    private String appid;
    private String secret;
}
