package cn.zjutleo.health_server.aspect;

import cn.zjutleo.health_server.annotation.RequestLimit;
import cn.zjutleo.health_server.constants.RedisConstants;
import cn.zjutleo.health_server.exception.runtimeApiException.RequestTimesExceededException;
import cn.zjutleo.health_server.service.RedisService;
import cn.zjutleo.health_server.util.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 访问限制切面类
 */
@Aspect
@Component
public class RequestLimitAspect {
    @Resource
    private RedisService redisService;

    @Pointcut("@annotation(requestLimit)")
    public void pointCut(RequestLimit requestLimit){
    }

    public void before(JoinPoint joinPoint, RequestLimit requestLimit) throws RequestTimesExceededException{
        // 在方法中获取请求上下文
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes != null){
            // 获取请求request
            HttpServletRequest request = attributes.getRequest();
            String ip = IpUtil.getIpAddr(request);
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            String key = RedisConstants.REFRESH_TOKEN_PREFIX + ip + ":" + className + "." + methodName;
            Integer currentAmount = (Integer) redisService.get(key);
            if(currentAmount == null){
                redisService.set(key, 1, requestLimit.time());
            } else {
                if(currentAmount > requestLimit.amount()){
                    throw new RequestTimesExceededException();
                } else {
                    redisService.incr(key, 1);
                }
            }
        }
    }
}
