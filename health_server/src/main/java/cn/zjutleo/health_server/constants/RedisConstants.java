package cn.zjutleo.health_server.constants;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: Redis相关常量类
 */
public class RedisConstants {
    /**
     * RefreshToken Redis前缀
     */
    public static final String REFRESH_TOKEN_PREFIX = "user:token:";

    /**
     * 打卡缓存key
     */
    public static final String TIMECARD_CACHE_KEY = "timecard:cache:";

}
