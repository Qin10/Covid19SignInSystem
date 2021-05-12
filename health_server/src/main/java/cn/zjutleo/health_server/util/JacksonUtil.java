package cn.zjutleo.health_server.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/10
 * @description: Jackson相关工具类
 */
public class JacksonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * javaBean、列表数组转换为json字符串
     *
     * @param obj 待转化对象
     * @return json字符串
     */
    public static String objToJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * json转换为JavaBean
     *
     * @param jsonString json字符串
     * @param clazz      目标类型
     * @return 目标Javabean
     */

    public static <T> T jsonToPojo(String jsonString, Class<T> clazz) throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper.readValue(jsonString, clazz);
    }

    /**
     * json字符串转换为Map
     *
     * @param jsonString json字符串
     * @return 目标Map
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> jsonToMap(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue(jsonString, Map.class);
    }
}
