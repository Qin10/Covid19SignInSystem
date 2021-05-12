package cn.zjutleo.health_server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 用户行为日志配置类
 */
@ConfigurationProperties("user-operation-log")
@Data
public class UserOperationLogConfig {
    private String format;
}