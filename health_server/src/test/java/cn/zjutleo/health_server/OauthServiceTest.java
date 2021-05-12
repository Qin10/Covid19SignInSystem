package cn.zjutleo.health_server;

import cn.zjutleo.health_server.pojo.Oauth;
import cn.zjutleo.health_server.service.OauthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: OauthService测试类
 */
@Slf4j
@SpringBootTest
public class OauthServiceTest {
    @Resource
    private OauthService oauthService;

    @Test
    void getOauthByOauthTypeAndOauthIdTest(){
        Oauth oauth = oauthService.getOauthByOauthTypeAndOauthId("wechat", "oOyAT5NTT-AJAuF4RMoyaXVUxgas");
        log.info(oauth.toString());
    }
}
