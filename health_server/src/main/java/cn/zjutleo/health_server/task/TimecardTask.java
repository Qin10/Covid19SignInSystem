package cn.zjutleo.health_server.task;

import cn.zjutleo.health_server.constants.RedisConstants;
import cn.zjutleo.health_server.service.RedisService;
import cn.zjutleo.health_server.service.TimecardService;
import cn.zjutleo.health_server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/22
 * @description: 打卡定时任务
 */
@Component
@Slf4j
public class TimecardTask {
    @Resource
    private RedisService redisService;
    @Resource
    private UserService userService;

    /**
     * 每天零点清除当天打卡缓存
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Async
    public void deleteTimecardToday(){
        log.info("开始清除当天打卡缓存");
        List<Integer> userIdList = userService.getAllUserId();
        for(Integer id : userIdList){
            redisService.del(RedisConstants.TIMECARD_CACHE_KEY + id.toString());
        }
        log.info("当天打卡缓存清除完成");
    }
}
