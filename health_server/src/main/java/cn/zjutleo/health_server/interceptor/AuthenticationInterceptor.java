package cn.zjutleo.health_server.interceptor;

import cn.zjutleo.health_server.annotation.PassAuthentication;
import cn.zjutleo.health_server.annotation.RequiresLogin;
import cn.zjutleo.health_server.config.JwtConfig;
import cn.zjutleo.health_server.constants.RedisConstants;
import cn.zjutleo.health_server.dto.JwtPayloadDto;
import cn.zjutleo.health_server.exception.apiException.AuthenticationException;
import cn.zjutleo.health_server.exception.apiException.authenticationException.JwtExpiredException;
import cn.zjutleo.health_server.exception.apiException.authenticationException.PermissionDeniedException;
import cn.zjutleo.health_server.exception.apiException.authenticationException.TokenCheckException;
import cn.zjutleo.health_server.exception.apiException.authenticationException.TokenNotFoundException;
import cn.zjutleo.health_server.service.RedisService;
import cn.zjutleo.health_server.util.IpUtil;
import cn.zjutleo.health_server.util.JwtUtil;
import cn.zjutleo.health_server.util.ThreadLocalUtil;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 鉴权拦截器
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Resource
    private RedisService redisService;
    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthenticationException {
        // 从http请求头中取出token(前端请求中在请求头Authorization字段中附加token)
        String token = request.getHeader("Authorization");
        // 若不是映射到方法则直接通过(Spring在对Controller进行注册时会遍历bean下的所有方法，对有映射的方法封装成HandlerMethod进行注册，同时也会注册相关的url等信息)
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 检查是否有passtoken注释，有则跳过认证
        if(method.isAnnotationPresent(PassAuthentication.class)){
            PassAuthentication passAuthentication = method.getAnnotation(PassAuthentication.class);
            if(passAuthentication.required()){
                return true;
            }
        }
        // 检查是否有需要用户权限的注解
        if(method.isAnnotationPresent(RequiresLogin.class)){
            RequiresLogin requiresLogin = method.getAnnotation(RequiresLogin.class);
            if(requiresLogin.required()){
                // 执行认证
                if(token == null){
                    throw new TokenNotFoundException("无token，请重新登录");
                }
                JwtPayloadDto jwtPayloadDto = JwtUtil.getPayload(token);
                try{
                    boolean verify = JwtUtil.verify(token, jwtPayloadDto, jwtConfig.getSecret());
                    if(!verify){
                        throw new TokenCheckException();
                    }
                } catch (TokenExpiredException e){
                    if(!refreshToken(token, jwtPayloadDto)){
                        throw new JwtExpiredException();
                    }
                }
                if(requiresLogin.requiresRoles().length > 0){
                    boolean hasPermission = false;
                    for(String typeId : requiresLogin.requiresRoles()){
                        if(typeId.equals((jwtPayloadDto.getTypeId().toString()))){
                            hasPermission = true;
                            break;
                        }
                    }
                    if(!hasPermission){
                        throw new PermissionDeniedException();
                    }
                }
                ThreadLocalUtil.setCurrentUser(jwtPayloadDto.getId());
                MDC.put("userId", jwtPayloadDto.getId().toString());
                MDC.put("ip", IpUtil.getIpAddr(request));
                return true;
            }
        }
        return true;
    }

    /**
     * 尝试刷新用户token
     *
     * @param token         过期token
     * @param jwtPayloadDto 当前用户的payload
     * @return 是否刷新成功
     */
    protected boolean refreshToken(String token, JwtPayloadDto jwtPayloadDto){
        String possibleToken = (String) redisService.get(RedisConstants.REFRESH_TOKEN_PREFIX + jwtPayloadDto.getId());
        if (possibleToken != null && possibleToken.equals(token)) {
            String newToken = JwtUtil.sign(jwtPayloadDto, jwtConfig.getSecret(), jwtConfig.getExpireTime());
            redisService.set(RedisConstants.REFRESH_TOKEN_PREFIX + jwtPayloadDto.getId(), newToken, jwtConfig.getRefreshTokenExpireTime());
            // 在方法中获取请求上下文
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletResponse response;
            if (requestAttributes != null) {
                response = requestAttributes.getResponse();
                if (response != null) {
                    response.setHeader("Authorization", newToken);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ThreadLocalUtil.removeCurrentUser();
        MDC.clear();
    }
}
