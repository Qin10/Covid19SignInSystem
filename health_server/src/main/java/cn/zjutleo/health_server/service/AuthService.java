package cn.zjutleo.health_server.service;

import cn.zjutleo.health_server.config.JwtConfig;
import cn.zjutleo.health_server.config.WechatConfig;
import cn.zjutleo.health_server.constants.OauthTypes;
import cn.zjutleo.health_server.constants.RedisConstants;
import cn.zjutleo.health_server.dto.JwtPayloadDto;
import cn.zjutleo.health_server.dto.WechatRegisterUserDto;
import cn.zjutleo.health_server.exception.apiException.AuthenticationException;
import cn.zjutleo.health_server.exception.apiException.AuthorizationException;
import cn.zjutleo.health_server.exception.apiException.daoException.SelectException;
import cn.zjutleo.health_server.pojo.Oauth;
import cn.zjutleo.health_server.pojo.User;
import cn.zjutleo.health_server.util.IpUtil;
import cn.zjutleo.health_server.util.JwtUtil;
import cn.zjutleo.health_server.util.WechatUtil;
import cn.zjutleo.health_server.vo.LoginInfoVo;
import cn.zjutleo.health_server.vo.UserVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/11
 * @description: 授权鉴权服务类
 */
@Service
public class AuthService {
    @Resource
    private UserService userService;
    @Resource
    private OauthService oauthService;
    @Resource
    private RedisService redisService;
    @Resource
    private JwtConfig jwtConfig;
    @Resource
    private WechatConfig wechatConfig;
    @Resource
    private HttpServletRequest request;

    /**
     * 处理微信登录或注册请求
     *
     * @param wechatRegisterUserDto 微信注册信息
     * @return token和用户部分信息
     * @throws JsonProcessingException jackson异常
     * @throws SelectException         查询异常
     * @throws AuthorizationException  授权异常
     */
    @Transactional(rollbackFor = Exception.class)
    public LoginInfoVo loginByWechat(WechatRegisterUserDto wechatRegisterUserDto) throws JsonProcessingException, SelectException, AuthorizationException{
        // 获取openid
        String openid = WechatUtil.getWxInfo(wechatRegisterUserDto.getCode(), wechatConfig.getAppid(), wechatConfig.getSecret()).getOpenid();
        if(openid == null){
            throw new AuthorizationException("非法授权码！");
        }
        Oauth wechatOauth = oauthService.getOauthByOauthTypeAndOauthId(OauthTypes.WECHAT, openid);
        if(wechatOauth != null){
            // 微信登录记录不为空进入
            // 处理登录
            return excuteLoginByUserId(wechatOauth.getUserId());
        } else {
            // 不存在微信登录记录进入
            // 创建用户
            User user = new User();
            // 1为普通用户
            user.setUTypeId(1);
            user.setUCreatedTime(new Timestamp(System.currentTimeMillis()));
            // 保存用户
            userService.saveUser(user);
            // 设置用户登录授权信息
            Oauth oauth = new Oauth();
            oauth.setUserId(user.getUId());
            oauth.setOauthId(openid);
            oauth.setOauthType(OauthTypes.WECHAT);
            // 保存用户登录授权信息
            oauthService.saveOauth(oauth);
            /**
             *
             * 保存其他相关信息，后期可扩展
             *
             */
            return excuteLoginByUserId(user.getUId());
        }
    }

    /**
     * 处理绑定微信请求
     *
     * @param userId 用户id
     * @param code   微信code
     * @throws Exception 抛出异常
     */
    public void bindWechat(int userId, String code) throws Exception {
        String openid = WechatUtil.getWxInfo(code, wechatConfig.getAppid(), wechatConfig.getSecret()).getOpenid();
        if (openid == null) {
            throw new AuthorizationException("非法授权码！");
        }
        if (oauthService.getOauthByOauthTypeAndUserId(OauthTypes.WECHAT, userId) != null) {
            throw new AuthorizationException("您已绑定过微信账号！");
        }
        if (oauthService.getOauthByOauthTypeAndOauthId(OauthTypes.WECHAT, openid) != null) {
            throw new AuthorizationException("该微信账号已被绑定过！");
        }
        Oauth oauth = new Oauth();
        oauth.setUserId(userId);
        oauth.setOauthType(OauthTypes.WECHAT);
        oauth.setOauthId(openid);
        oauthService.saveOauth(oauth);
    }

    /**
     * 签署token令牌
     *
     * @param userVo 用户信息封装
     * @return token令牌
     */
    private String signToken(UserVo userVo){
        // 将用户信息封装在payload部分中
        JwtPayloadDto jwtPayloadDto = JwtUtil.packagePayload(userVo);
        // 生成token
        String token = JwtUtil.sign(jwtPayloadDto, jwtConfig.getSecret(), jwtConfig.getExpireTime());
        // 存入redis
        redisService.set(RedisConstants.REFRESH_TOKEN_PREFIX + userVo.getUId(), token, jwtConfig.getRefreshTokenExpireTime());
        return token;
    }

    /**
     * 处理登录过程
     *
     * @param userId 用户id
     * @return token和用户部分信息
     * @throws SelectException 用户未找到异常
     */
    private LoginInfoVo excuteLoginByUserId(int userId) throws SelectException {
        // 查找该用户
        UserVo userVo = userService.getExistUserVoById(userId);
        /**
         *
         * 可在此插入广播消息，后期可扩展
         *
         */
        // 签署token
        String token = signToken(userVo);
        // 多线程日志记录
        MDC.put("userId", userVo.getUId().toString());
        MDC.put("ip", IpUtil.getIpAddr(request));
        return new LoginInfoVo(token, userVo);
    }

    /**
     * 处理用户登出请求，移除token
     *
     * @param userId 用户id
     */
    public void logout(Integer userId) {
        // 从Redis缓存中移除
        redisService.del(userId.toString());
    }

}
