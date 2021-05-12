package cn.zjutleo.health_server;

import cn.zjutleo.health_server.config.JwtConfig;
import cn.zjutleo.health_server.config.UserOperationLogConfig;
import cn.zjutleo.health_server.config.WechatConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/9
 * @description: Springboot启动类
 */
@SpringBootApplication
@EnableConfigurationProperties({WechatConfig.class, JwtConfig.class, UserOperationLogConfig.class})
@MapperScan(basePackages = "cn.zjutleo.health_server.mapper")
@EnableScheduling
@EnableAsync
public class HealthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthServerApplication.class, args);
        System.out.println("Success!");
    }
}
