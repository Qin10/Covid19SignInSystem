package cn.zjutleo.health_server.controller;

import cn.zjutleo.health_server.annotation.RequestLimit;
import cn.zjutleo.health_server.annotation.RequiresLogin;
import cn.zjutleo.health_server.dto.UserDto;
import cn.zjutleo.health_server.exception.apiException.daoException.SelectException;

import cn.zjutleo.health_server.service.UserService;
import cn.zjutleo.health_server.util.ThreadLocalUtil;
import cn.zjutleo.health_server.vo.PageVo;
import cn.zjutleo.health_server.vo.ResponseBean;
import cn.zjutleo.health_server.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Qin Zhenghan
 * @date : Created in 2021/5/16
 * @description: 用户相关请求
 */
@Slf4j(topic = "topicOperationLog")
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 更新用户信息
     *
     * @param userDto
     * @return
     */
    @RequestLimit
    @RequiresLogin
    @PutMapping("/me")
    public ResponseBean<Object> updatePersonalUserInfo(@RequestBody UserDto userDto) {
        // 获取当前用户线程
        Integer userId = ThreadLocalUtil.getCurrentUser();
        try {
            userService.updateUserByUserId(userDto, userId);
        } catch (SelectException e) {
            e.printStackTrace();
        }
        return new ResponseBean(200, "succ", null);
    }

    /**
     * 获取当前用户信息
     *
     * @return
     */
    @RequiresLogin
    @GetMapping("/me")
    public ResponseBean<Object> getUserVo(){
        Integer userId = ThreadLocalUtil.getCurrentUser();
        UserVo userVo = userService.getUserVoById(userId);
        return new ResponseBean<>(200, "succ", userVo);
    }

    /**
     * 根据id获取用户信息
     * @param userId
     * @return
     */
    @RequiresLogin
    @GetMapping("/{userId}")
    public ResponseBean<Object> getUserVoById(@PathVariable("userId") Integer userId){
        UserVo userVo = userService.getUserVoById(userId);
        return new ResponseBean<>(200, "succ", userVo);
    }

}
