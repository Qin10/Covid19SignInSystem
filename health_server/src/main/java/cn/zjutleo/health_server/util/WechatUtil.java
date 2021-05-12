package cn.zjutleo.health_server.util;

import cn.zjutleo.health_server.dto.WechatDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/10
 * @description: 微信小程序鉴权授权工具类
 */
public class WechatUtil {

    /**
     * code2session请求url
     */
    private static final String WECHAT_AUTH_URL_FORMAT = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&grant_type=authorization_code&js_code=%s";

    /**
     * RestTemplate
     */
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    /**
     * 传入微信请求code返回授权校验结果
     *
     * @param code 微信请求code
     * @return 包含了各种校验信息的Map
     */
    public static WechatDto getWxInfo(String code, String appid, String secret) throws JsonProcessingException{
        String requestUrl = String.format(WECHAT_AUTH_URL_FORMAT, appid, secret, code);
        ResponseEntity<String> responseEntity = REST_TEMPLATE.postForEntity(requestUrl, null, String.class);
        String responseStr = responseEntity.getBody();
        return JacksonUtil.jsonToPojo(responseStr, WechatDto.class);
    }

}
