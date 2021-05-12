package cn.zjutleo.health_server;

import cn.zjutleo.health_server.dto.WechatDto;
import cn.zjutleo.health_server.util.WechatUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 传入code返回授权校验结果测试类
 */
@Slf4j
@SpringBootTest
public class WxInfoTest {
    @Resource
    private WechatUtil wechatUtil;

    @Test
    void getWxInfoTest() throws JsonProcessingException {
        WechatDto wechatDto = wechatUtil.getWxInfo("", "", "");
        log.info(wechatDto.toString());
    }
}
