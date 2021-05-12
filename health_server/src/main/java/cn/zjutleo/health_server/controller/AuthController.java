package cn.zjutleo.health_server.controller;

import cn.zjutleo.health_server.annotation.RequestLimit;
import cn.zjutleo.health_server.annotation.RequiresLogin;
import cn.zjutleo.health_server.config.UserOperationLogConfig;
import cn.zjutleo.health_server.dto.WechatRegisterUserDto;
import cn.zjutleo.health_server.service.AuthService;
import cn.zjutleo.health_server.util.ThreadLocalUtil;
import cn.zjutleo.health_server.vo.LoginInfoVo;
import cn.zjutleo.health_server.vo.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/12
 * @description: 授权鉴权类请求
 */
@RestController
@Slf4j(topic = "userOperationLog")
public class AuthController {
    protected static final String MODULE_NAME = "登录注册模块";
    @Resource
    private AuthService authService;
    @Resource
    private UserOperationLogConfig userOperationLogConfig;

    /**
     * 登出
     */
    @RequiresLogin
    @GetMapping("/logout")
    public ResponseBean<Object> logout() {
        Integer userId = ThreadLocalUtil.getCurrentUser();
        authService.logout(userId);
        return new ResponseBean<>(200, "登出成功", null);
    }

    /**
     * 绑定微信账号
     *
     * @param code 小程序请求码
     */
    @RequestLimit(amount = 1, time = 180)
    @RequiresLogin
    @PostMapping("/bind/wechat")
    public ResponseBean<Object> wechatBind(@RequestParam("code") String code) throws Exception {
        Integer userId  = ThreadLocalUtil.getCurrentUser();
        authService.bindWechat(userId, code);
        return new ResponseBean<>(200, "succ", null);
    }

    /**
     * 通过微信号登录或注册
     *
     * @param wechatRegisterUserDto 包含注册信息的实体
     */
    @RequestLimit(amount = 5, time = 180)
    @PostMapping("/login/wechat")
    public ResponseBean<LoginInfoVo> loginByWechat(@RequestBody @Validated WechatRegisterUserDto wechatRegisterUserDto) throws Exception {
        LoginInfoVo loginInfoVo;
        loginInfoVo = authService.loginByWechat(wechatRegisterUserDto);
        log.info(userOperationLogConfig.getFormat(), MODULE_NAME, "用户登录", "");
        return new ResponseBean<>(200, "登录成功", loginInfoVo);
    }
}
